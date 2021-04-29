/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.pattern.microservice.ambassador;

import static com.pattern.microservice.ambassador.RemoteServiceStatus.FAILURE;
import static java.lang.Thread.sleep;

/**
 * ServiceAmbassador provides an interface for a ({@link Client}) to access ({@link RemoteService}).
 * The interface adds logging, latency testing and usage of the service in a safe way that will not
 * add stress to the remote service when connectivity issues occur.
 */
public class ServiceAmbassador implements RemoteServiceInterface {

  private static final int RETRIES = 3;
  private static final int DELAY_MS = 3000;

  ServiceAmbassador() {
  }

  @Override
  public long doRemoteFunction(int value) {
    return safeCall(value);
  }

  private long checkLatency(int value) {
    long startTime = System.currentTimeMillis();
    long result = RemoteService.getRemoteService().doRemoteFunction(value);
    long timeTaken = System.currentTimeMillis() - startTime;

    System.out.println("Time taken (ms): {}"+timeTaken);
    return result;
  }

  private long safeCall(int value) {
    long retries = 0;
    long result = FAILURE.getRemoteServiceStatusValue();

    for (int i = 0; i < RETRIES; i++) {
      if (retries >= RETRIES) {
        return FAILURE.getRemoteServiceStatusValue();
      }

      if ((result = checkLatency(value)) == FAILURE.getRemoteServiceStatusValue()) {
        System.out.println("Failed to reach remote: " + (i + 1));
        retries++;
        try {
          sleep(DELAY_MS);
        } catch (InterruptedException e) {
          System.out.println("Thread sleep state interrupted" +  e.getMessage());
          Thread.currentThread().interrupt();
        }
      } else {
        break;
      }
    }
    return result;
  }
}
