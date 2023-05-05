package pe.edu.upc.theraphyapplication.ui.screens.patientList

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pe.edu.upc.theraphy.data.model.Patient

@Composable
fun PatientList(patients: List<Patient>, selectPatient: (String)-> UInt){
    LazyColumn(){
        itemsIndexed(patients){ index, item ->
            PatientItem(item){
                selectPatient("${index + 1}")
            }
        }
    }
}


@Composable
private fun PatientItem(patient: Patient, selectPatient: () -> Unit){
    Card(
        onClick = {
            selectPatient ()
        }) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = patient.firstName)
        }
    }
}