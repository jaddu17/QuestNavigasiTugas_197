package com.example.tugaspertemuan6.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugaspertemuan6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPendaftaran(
    OnKembaliBtnClick: () -> Unit,
    OnSubmitBtnClick: () -> Unit
) {
    var textNama by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    val gender:List<String> = listOf("Laki-Laki", "Perempuan")
    val kawin:List<String> = listOf("Single", "Taken", "HTS")

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Formulir Pendaftaran")},
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = colorResource(id = R.color.hijau_muda))
            )
        },
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize()
                .background(colorResource(id = R.color.hijau_muda)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, bottom = 12.dp, end = 12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.cokelat)
                )
            ) {
                Text(
                    stringResource(id = R.string.nama_lengkap),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 12.dp, start = 16.dp, bottom = 10.dp)
                )
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 12.dp),
                    label = { Text(text = "Isian Nama Lengkap") },

                    onValueChange = {
                        textNama = it
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    stringResource(id = R.string.jenis_kelamin),
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 16.dp)
                )
                Row {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                )
                                .padding(end = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            Text(item)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    stringResource(id = R.string.status),
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 16.dp)
                )
                Row {
                    kawin.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item }
                                )
                                .padding(end = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            )
                            Text(item)
                        }
                    }
                }
                Text(
                    stringResource(id = R.string.alamat),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 12.dp, start = 16.dp, bottom = 10.dp)
                )
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                    label = { Text(text = "Isikan alamat") },

                    onValueChange = {
                        textAlamat = it
                    }
                )
                Spacer(modifier = Modifier.padding(top = 130.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        modifier = Modifier.weight(1f)
                            .padding(start = 10.dp, bottom = 5.dp)
                            .size(50.dp),
                        onClick = OnKembaliBtnClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.hijau_busuk)
                        )
                    ) {
                        Text(stringResource(id = R.string.beranda))
                    }

                    Button(
                        modifier = Modifier.weight(1f)
                            .padding(end = 10.dp, bottom = 5.dp)
                            .size(50.dp),
                        onClick = {
                            namaLengkap = textNama
                            jenisKelamin = textJK
                            status = textStatus
                            alamat = textAlamat
                            showDialog = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.hijau_busuk)
                        ),
                    ) {
                        Text(stringResource(id = R.string.submit))
                    }
                }
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            TextButton(onClick = { showDialog = false
                                OnSubmitBtnClick() }) {
                                Text("OK")
                            }
                        },
                        title = { Text("Data Berhasil Disimpan") },
                        text = {
                            Column {
                                Text("Nama : " +namaLengkap)
                                Text("Jenis Kelamin :" + jenisKelamin)
                                Text("Status : " + status)
                                Text("Alamat : " + alamat)
                            }
                        }
                    )
                }
            }
        }
    }
}
