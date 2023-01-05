package com.mbs.api_recycler


import UserModel
import android.util.Log
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    val response = RetrofitService.api.list().execute()

    //Verificar se o nome do array é "users"
    @Test
    fun checkArrayName() {
        var resp: UserModel? = null
        try {
            response
        } catch (e: Exception) {
            Log.e("erro", e.message.toString())
        } finally {
            if (response.isSuccessful) {
                resp = response.body()
            }
        }
        if (resp != null) {
            assertEquals("users", resp::users.name.lowercase())
        } else Assert.fail()
    }


    //Verificar se o tamanho do array users é > 0
    @Test
    fun verifyArrayLenght() {
        var resp: UserModel? = null
        try {
            response
        } catch (e: Exception) {
            Log.e("erro", e.message.toString())
        } finally {
            if (response.isSuccessful) {
                resp = response.body()
            }
        }
        assertTrue(resp?.users?.size!! > 0)
    }

    //Verificar se o código de resposta da chamada é 200.
    @Test
    fun verifyResponseStatus200() {
        var resp = 0
        try {
            response
        } catch (e: Exception) {
            Log.e("erro", e.message.toString())
        } finally {
            if (response.isSuccessful) {
                resp = response.code()
            }
        }
        assertTrue(resp == 200)
    }
}