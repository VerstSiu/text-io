package com.ijoic.textio.commonio

import com.ijoic.textio.common.mapFileStream
import com.ijoic.textio.common.mapResStream
import org.apache.commons.io.IOUtils
import java.nio.charset.Charset

/**
 * Parse current file path to text content
 */
fun String.toFileText(ignoreError: Boolean = false, charset: Charset = Charsets.UTF_8): String? {
  return mapFileStream(ignoreError) { IOUtils.toString(it, charset) }
}

/**
 * Parse current res path to text content
 */
fun String.toResText(ignoreError: Boolean = false, charset: Charset = Charsets.UTF_8): String? {
  return mapResStream(ignoreError) { IOUtils.toString(it, charset) }
}