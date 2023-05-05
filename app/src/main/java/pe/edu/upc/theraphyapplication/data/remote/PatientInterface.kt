package pe.edu.upc.theraphy.data.remote

import pe.edu.upc.theraphy.data.model.Patient
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PatientInterface {
    @GET("patients")
    fun getAllPatients(): Call<ApiResponse>

    @GET("patients/{id}")
    fun getPatientById(@Path("id")id: String): Call<Patient>



}