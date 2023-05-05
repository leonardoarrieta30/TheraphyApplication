package pe.edu.upc.theraphy.data.remote

import com.google.gson.annotations.SerializedName
import pe.edu.upc.theraphy.data.model.Patient

data class ApiResponse(
    @SerializedName("content")
    val patients : ArrayList<Patient>
)
