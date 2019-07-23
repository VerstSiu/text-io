/*
 *
 *  Copyright(c) 2019 VerstSiu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.ijoic.textio.common

import java.io.FileInputStream
import java.io.InputStream
import java.lang.Exception

/**
 * Convert current path as file stream and map to result entity
 */
fun <T> String.mapFileStream(ignoreError: Boolean = false, map: (InputStream) -> T?): T? {
  if (this.isBlank()) {
    return null
  }
  var input: InputStream? = null

  try {
    input = FileInputStream(this)
    return map.invoke(input)

  } catch (e: Exception) {
    if (!ignoreError) {
      e.printStackTrace()
    }
  } finally {
    input?.runCatching { this.close() }
  }
  return null
}

/**
 * Convert current path as resource stream and map to result entity
 */
fun <T> String.mapResStream(ignoreError: Boolean = false, map: (InputStream) -> T?): T? {
  if (this.isBlank()) {
    return null
  }
  var input: InputStream? = null

  try {
    input = Thread.currentThread().contextClassLoader.getResourceAsStream(this)
    return map.invoke(input)

  } catch (e: Exception) {
    if (!ignoreError) {
      e.printStackTrace()
    }
  } finally {
    input?.runCatching { this.close() }
  }
  return null
}