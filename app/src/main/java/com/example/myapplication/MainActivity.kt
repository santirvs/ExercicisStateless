package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.HorizontalAlign
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    ExercicisStateless(modifier = Modifier.padding(padding), 1)
                }

            }
        }
    }
}

@Composable
fun Alerta(exercici: Int, modifier: Modifier = Modifier) {
    Text(
        text = "ERROR l'exercici $exercici no existeix.",
        modifier = modifier
    )
}

@Composable
fun ExercicisStateless(modifier: Modifier = Modifier, exercici: Int = 1) {

    when (exercici) {
        1 -> Exercici1(modifier)
        2 -> Exercici2(modifier)
        3 -> Exercici3(modifier)
        4 -> Exercici4(modifier)
        5 -> Exercici5(modifier)
        else -> Alerta(exercici, modifier)
    }
}

@Composable
fun Exercici1(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier
        .fillMaxSize()
        .padding(vertical = 50.dp)) {
        Column(modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = "Example"
            )
            Text(
                stringResource(R.string.ex1_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
            Text(
                stringResource(R.string.ex1_par1),
                modifier = modifier.padding(10.dp),
                textAlign = TextAlign.Justify
            )
            Text(stringResource(R.string.ex1_par2),
                modifier = modifier.padding(10.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun Exercici2(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier
        .fillMaxSize()
        .padding(vertical = 50.dp)) {
        Column(modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_task_completed),
                contentDescription = "Completed",
                modifier = modifier.align(Alignment.CenterHorizontally)
            )
            Text(stringResource(R.string.ex2_allTasksCompleted),
                modifier = modifier.padding(10.dp).align(Alignment.CenterHorizontally),
                fontWeight =  FontWeight.Bold
            )
            Text(stringResource(R.string.ex2_niceWork),
                modifier = modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun Exercici3(modifier: Modifier = Modifier) {
    Column() {
        Row(modifier.weight(1.0f)) {
            Column(modifier.weight(1.0f)
                    .background(color=colorResource(R.color.ex4_color1))
                    .fillMaxSize( ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    stringResource(R.string.ex3_box1_title),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp)
                )
                Text(
                    stringResource(R.string.ex3_box1_text),
                    modifier = modifier.padding(10.dp),
                    textAlign = TextAlign.Justify
                )
            }
            Column(modifier.weight(1.0f)
                    .background(color=colorResource(R.color.ex4_color2))
                    .fillMaxSize( ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    stringResource(R.string.ex3_box2_title),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp)
                )
                Text(
                    stringResource(R.string.ex3_box2_text),
                    modifier = modifier.padding(10.dp),
                    textAlign = TextAlign.Justify
                )

            }
        }

        Row( modifier.weight(1.0f) ) {
            Column(modifier.weight(1.0f)
                    .background(color=colorResource(R.color.ex4_color3))
                    .fillMaxSize( ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    stringResource(R.string.ex3_box3_title),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp),

                )
                Text(
                    stringResource(R.string.ex3_box3_text),
                    modifier = modifier.padding(10.dp),
                    textAlign = TextAlign.Justify
                )
            }
            Column(modifier.weight(1.0f)
                    .background(color=colorResource(R.color.ex4_color4))
                    .fillMaxSize( ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(R.string.ex3_box4_title),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp)

                )
                Text(
                    stringResource(R.string.ex3_box4_text),
                    modifier = modifier.padding(10.dp),
                    textAlign = TextAlign.Justify
                )

            }
        }

    }
}

@Composable
fun Exercici4(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()

        Box(modifier = Modifier
            .size(120.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(120.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(120.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(120.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(120.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })

    }
}

@Composable
fun Exercici5(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()
        //.background(color=colorResource(R.color.ex5_background))
        .background(color=Color.Yellow)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment =  Alignment.CenterVertically,
            modifier = modifier.fillMaxSize().weight(0.25f)) {
            Box(
                modifier
                    .size(100.dp)
                    .background(Color.Red)
            )
        }
        Row( modifier = modifier.fillMaxSize().weight(0.1f),
            horizontalArrangement = Arrangement.Center) {
            Text(
                "Jeniffer Doe",
                fontSize = 40.sp,
                modifier = modifier.padding(10.dp)
            )
        }
        Row( modifier = modifier.fillMaxSize().weight(0.1f),
            horizontalArrangement = Arrangement.Center) {
            Text(
                "Android Developer Extraordinaire",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
        }
        Row(  modifier = modifier.fillMaxSize().weight(0.1f),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = Icons.Default.Star,
                contentDescription = "Icon Example",
                tint = Color.Blue)
            Text(
                "+11 (123) 444 555 666",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
        }
        Row(  modifier = modifier.fillMaxSize().weight(0.1f),
            horizontalArrangement = Arrangement.Center) {
            Icon(imageVector = Icons.Default.Star,
                contentDescription = "Icon Example",
                tint = Color.Blue)
            Text(
                "@AndroidDev",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
        }
        Row(  modifier = modifier.fillMaxSize().weight(0.1f),
            horizontalArrangement = Arrangement.Center) {
            Icon(imageVector = Icons.Default.Star,
                contentDescription = "Icon Example",
                tint = Color.Blue
            )
            Text(
                "jen.doe@android.com",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
        }
    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        ExercicisStateless(exercici = 5)
    }
}