package Project.UTS

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import Project.UTS.ui.theme.UTSTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Matkul(val namamatkul: String, val sks: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSTheme {
                val listan = datalist()

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(200.dp),
                    contentPadding = PaddingValues(16.dp)
                )
                {
                    items(listan.size) { index ->
                        matkulcard(matkul = listan[index])
                    }
                }
            }
        }
    }
}

@Composable
fun datalist(): List<Matkul>{
    val list= mutableListOf<Matkul>()

    list.add(Matkul("Statistika dan Probabilitas", 3))
    list.add(Matkul("Mobile Computing", 2))
    list.add(Matkul("STEM", 2))
    list.add(Matkul("Matematika Diskrit", 3))
    list.add(Matkul("Wawasan Pendidikan", 2))
    list.add(Matkul("Komputer dan Masyarakat", 3))
    list.add(Matkul("Filsafat", 2))
    list.add(Matkul("Kalkulus Integral", 3))
    list.add(Matkul("Kalkulus Diferensial", 3))
    list.add(Matkul("Animasi Komputer", 3))
    list.add(Matkul("Teori Bahasa Automata", 3))
    list.add(Matkul("Perancangan Pemograman Web", 3))
    list.add(Matkul("Pengantar teori Graph", 3))

    return list
}

@Composable
fun matkulcard(matkul: Matkul) {
    val image = painterResource(id = R.drawable.lambang_unj_dan_moto)
    Card(
        modifier = Modifier
            .size(100.dp)
            .padding(6.dp),
        elevation= CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray))
    {
        Box(contentAlignment = Alignment.Center)
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = image, contentDescription = null)
                Column {
                    Text(
                        text = matkul.namamatkul,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp)
                    )
                    Text(
                        text = "${matkul.sks} SKS",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 4.dp)
                    )
                }
            }
        }
    }
}
