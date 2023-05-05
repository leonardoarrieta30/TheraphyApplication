package pe.edu.upc.theraphy.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.theraphy.data.model.Patient
import pe.edu.upc.theraphy.data.remote.ApiClient
import pe.edu.upc.theraphy.data.remote.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "drivers") {
        composable("drivers") {
            val patients = remember {
                mutableStateOf(emptyList<Patient>())
            }
            val patientInterface = ApiClient.build()
            val getAllPatients = patientInterface.getAllPatients()

            getAllPatients.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(
                    call: Call<ApiResponse>,
                    response: Response<ApiResponse>
                ) {
                    if (response.isSuccessful) {
                        patients.value = response.body()?.patients!!
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

                }
            })
//            PatientList(
//                patients = patients.value,
//                selectPatient = { index ->
//                    navController.navigate("patient/$index")
//                }
//            )
        }
    }
}