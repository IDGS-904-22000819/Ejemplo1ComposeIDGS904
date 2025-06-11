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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// Definición de una clase de datos para representar un personaje
//data class es una clase que se usa para almacenar datos
data class PersonajeTarjeta(val title: String, val body: String)

// Lista de personajes
private val tarjetas:List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z"),
    PersonajeTarjeta("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso"),
    PersonajeTarjeta("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer"),
    PersonajeTarjeta("Gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT"),
    PersonajeTarjeta("Android17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian"),
    PersonajeTarjeta("Bills", "Dios de la Destrucción Beerus, conocido también como Beers, o Bills en Hispanoamérica e inicialmente en España[1], es un personaje que fue introducido en la película Dragon Ball Z: La batalla de los dioses, donde es el antagonista principal de la película"),
    PersonajeTarjeta("Jiren", "Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo"),
    PersonajeTarjeta("Vegetto", "Vegetto es el personaje más fuerte dentro del manga original y uno de los personajes más poderosos de toda la serie en general. Su poder es el resultado del máximo poder combinado de Goku y Vegeta"),
    PersonajeTarjeta("Broly", "Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario")
)


// Clase principal de la aplicación (MainActivity) que extiende ComponentActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilita que la UI llegue hasta los bordes de la pantalla
        setContent { // Carga la interfaz usando Jetpack Compose
            Ejemplo1ComposeIDGS904Theme { //  aplica un tema personalizado
                Tarjeta(tarjetas)  // Se llama al componente composable que muestra la tarjeta
            }
        }
    }
    /*
   Jetpack Compose:  es un kit de herramientas moderno y declarativo desarrollado por Google para
   simplificar y acelerar la creación de interfaces de usuario  nativas en Android,
   utilizando exclusivamente el lenguaje Kotlin
  */


    /*
 -----------------------------------------------------------------------------------
 ¿QUÉ ES UN COMPOSABLE?
 -----------------------------------------------------------------------------------
 Un Composable es una función anotada con @Composable en Jetpack Compose que se utiliza para construir componentes de la interfaz gráfica
 de forma declarativa en Kotlin

 Como ya se menciono estas funciones se marcan con la anotación @Composable.

Estas funciones se llaman "Composables". Pueden ser:
 1. Composables del sistema (predefinidos): como Row, Column, Text, Image, etc.
 2. Composables personalizados: como mi función ImagenPersonaje(), Tarjeta(), etc.

 En lugar de definir la interfaz usando archivos XML (como en el enfoque tradicional de Android),
 Jetpack Compose permite describir la UI directamente con código Kotlin. Esto facilita
 una mayor flexibilidad y una integración más directa con la lógica de la aplicación.

 Jetpack Compose observa automáticamente los cambios en los datos y vuelve a renderizar
 los componentes necesarios, lo que permite crear interfaces reactivas y eficientes.


 -----------------------------------------------------------------------------------
 DIFERENCIA ENTRE PROGRAMACIÓN IMPERATIVA Y DECLARATIVA
 -----------------------------------------------------------------------------------
 - En la programación imperativa (como el enfoque tradicional con XML y métodos en Java/Kotlin),
   se describe *cómo* se debe construir la interfaz paso a paso.

 - En la programación declarativa (como Jetpack Compose), se describe *qué* debe mostrarse
   en función del estado actual de los datos. El sistema se encarga automáticamente de actualizar
   la UI cuando esos datos cambian.
 -----------------------------------------------------------------------------------
*/


    // Composable principal que representa una tarjeta con imagen y texto
    @Composable  // Es una anotación en Jetpack Compose que identifica una función que construye un componente de la interfaz gráfica
    // Sin la anotacion, la función no podrá usarse para definir elementos visuales
    // Este Composable es PERSONALIZADO
    //Le pasos el listado de tarjetas a la funcion composable
    fun Tarjeta(personajes: List<PersonajeTarjeta>) {
        //LazyColumn es un componente diseñado para mostrar listas de elementos desplazables verticalmente de manera eficiente
        //A diferencia de un Columna simple (que compone y renderiza todos sus hijos de una vez, incluso los que no son visibles en pantalla)
        LazyColumn(
            modifier = Modifier
                .padding(24.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(personajes) { personaje ->
                MyPersonaje(personaje = personaje)
              }

            }
    }

    @Composable
    fun MyPersonaje(personaje: PersonajeTarjeta) {
        Card (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
                .fillMaxWidth(),
                 elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                 shape = RoundedCornerShape(16.dp),
                 colors=CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ){
            Row() {
                ImagenPersonaje(personaje.title)
                Personajes(personaje)
            }

        }
    }

    @Composable
    fun Personajes(personaje: PersonajeTarjeta) {
        Column {
          Personaje(personaje.title,
                MaterialTheme.colorScheme.primary,
                MaterialTheme.typography.titleLarge
              )
            Personaje(personaje.body,
                MaterialTheme.colorScheme.onBackground,
                MaterialTheme.typography.bodySmall
                )
        }
    }

    //Composable que muestra una imagen circular con un fondo de color y padding
    @Composable
    fun ImagenPersonaje(imageName: String) {
        val context= LocalContext.current;
        val ImageResid = remember (imageName){
            context.resources.getIdentifier(
                imageName.lowercase(),
                "drawable",
                context.packageName
            )
        }


        Image( // Composable que se usa para mostrar una imagen en pantalla
            painter = painterResource(id=ImageResid),
            // painter: Especifica el recurso de imagen que se va a cargar (en este caso una imagen de "vegeta_normal")
            // painterResource carga imágenes que están en la carpeta res/drawable

            contentDescription = imageName,
            // contentDescription: Descripción accesible para usuarios con lectores de pantalla.
            // Es importante para accesibilidad, aunque no se muestra en la UI.

            modifier = Modifier // Aquí empieza la configuración visual de la imagen usando Modifiers
                .padding(8.dp)
                // padding: Agrega un espacio de 8dp alrededor de la imagen

                .clip(CircleShape)
                // clip: Recorta la imagen con la forma especificada (en este caso, un círculo)
                // Esto hace que la imagen tenga bordes redondos en forma de círculo

                .size(100.dp)
                // size: Define el tamaño de la imagen en 100dp de ancho y alto

                .background(MaterialTheme.colorScheme.primary)
            // background: Asigna un color de fondo a la imagen recortada (usando el color primario del tema)
        )
    }


    //  Composable que muestra el nombre y la descripción de un personaje usando una disposición vertical
    @Composable // Anotación que indica que la función es un Composable de Jetpack Compose
    fun Personaje(name: String, color: Color, style: TextStyle) {
        Column {
            // Column: contenedor que organiza los elementos hijos de forma vertical (de arriba hacia abajo)
            Text(text = name)
            // Text: Composable que muestra texto en pantalla
            // En este caso, se muestra el nombre del personaje

        }
    }


@Preview(showBackground = true)
// -----------------------------------------------------------------------------------
// Esta anotación le dice a Android Studio que esta función es una "vista previa" de la UI.
// Es útil para **ver cómo se verá tu Composable sin ejecutar la app en el emulador o en un dispositivo**.
//
// showBackground = true: le indica a la vista previa que debe mostrar un fondo de pantalla, si no tendra fondo transparente
// -----------------------------------------------------------------------------------
    @Composable
// Esta función es un Composable como cualquier otro,
// pero al estar anotada con @Preview, Android Studio la ejecutará solo en el modo de vista previa.
// No se ejecuta en tiempo de ejecución real de la app, solo para mostrar la UI en el editor

    fun PreviewMessageCard() {
        // Esta función se usa solo para fines de vista previa (preview) en el editor.
        // No se ejecuta cuando usas la app normalmente, solo en el modo de diseño
        Tarjeta(tarjetas)
        // Llama al Composable "Tarjeta" para mostrarla como vista previa
    }

}