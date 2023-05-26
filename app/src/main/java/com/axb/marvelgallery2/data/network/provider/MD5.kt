package com.axb.marvelgallery2.data.network.provider

import java.math.BigInteger
import java.security.MessageDigest

/**
 * Calculate MD5 hash for text
 * @param timeStamp Current timeStamp
 * @return MD5 hash string
 */
fun calculatedMd5(text: String): String {
    val messageDigest = getMd5Digest(text)
    val md5 = BigInteger(1, messageDigest).toString(16)
    return "0" * (32 - md5.length) + md5 // 3.若小于 32 位 ，则使用 时间扩展操作符，并利用 0 值填充
}

private fun getMd5Digest(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray())

private operator fun String.times(i: Int) = (1..i).fold("") { acc, _ -> acc + this }