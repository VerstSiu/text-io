package com.ijoic.textio.common

import java.util.*

/**
 * Map current text to file properties
 */
fun String.toFileProperties(ignoreError: Boolean = false): Properties? {
  return mapFileStream(ignoreError) { Properties().apply { load(it) } }
}

/**
 * Map current text to resource properties
 */
fun String.toResProperties(ignoreError: Boolean = false): Properties? {
  return mapResStream (ignoreError) { Properties().apply { load(it) } }
}