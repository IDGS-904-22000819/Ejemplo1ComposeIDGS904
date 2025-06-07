package org.utl.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.utl.ejemplo1composeidgs904.ui.theme.Ejemplo1ComposeIDGS904Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS904Theme {
            Tarjeta()
        }
    }
}

data class Personaje(val nombre: String, val descripcion: String)


@Composable
fun Tarjeta() {
    Row(
        modifier = Modifier.padding(top=16.dp)
            .background(MaterialTheme.colorScheme.background)
    ){
        ImagenPersonaje()
        Personaje()
    }
}


@Composable
fun ImagenPersonaje(){
    Image(
        painter = painterResource(id = R.drawable.vegeta_normal),
        contentDescription = "Vegeta",
        modifier = Modifier.
        padding(8.dp).
        clip(CircleShape)
        .size(100.dp)
        .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun Personaje(){
    Column {
        Text("Nombre:Vegeta")
        Spacer(modifier = Modifier.height(5.dp))
        Text("Descripcion: Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. ")
    }
}


@Preview (showBackground = true)
@Composable
fun PreviewMessageCard() {
    Tarjeta()
}
}

