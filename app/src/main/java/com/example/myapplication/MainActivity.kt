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
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
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
        5 -> MyConstraintLayout_Images(modifier)
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
            Text(stringResource(R.string.ex1_par1), modifier = modifier.padding(10.dp), textAlign = TextAlign.Justify)
            Text(stringResource(R.string.ex1_par2), modifier = modifier.padding(10.dp), textAlign = TextAlign.Justify)
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
        Row() {
            Column() {
                Text(
                    stringResource(R.string.ex3_box1_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp).weight(1.0f)
                )
                Text(
                    stringResource(R.string.ex3_box1_text),
                    modifier = modifier.padding(10.dp).weight(1.0f),
                    textAlign = TextAlign.Justify
                )
            }
            Column() {
                Text(
                    stringResource(R.string.ex3_box2_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp).weight(1.0f)
                )
                Text(
                    stringResource(R.string.ex3_box2_text),
                    modifier = modifier.padding(10.dp).weight(1.0f),
                    textAlign = TextAlign.Justify
                )

            }
        }

        Row( ) {
            Column() {
                Text(
                    stringResource(R.string.ex3_box3_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp).weight(1.0f)
                )
                Text(
                    stringResource(R.string.ex3_box3_text),
                    modifier = modifier.padding(10.dp).weight(1.0f),
                    textAlign = TextAlign.Justify
                )
            }
            Column() {
                Text(
                    stringResource(R.string.ex3_box4_title),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(10.dp).weight(1.0f)
                )
                Text(
                    stringResource(R.string.ex3_box4_text),
                    modifier = modifier.padding(10.dp).weight(1.0f),
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
fun MyConstraintLayout_chains(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier
        .fillMaxSize()
        .padding(vertical = 100.dp)) {
        val (boxRed, boxYellow, boxGreen) = createRefs()
        Box(modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                start.linkTo(parent.start)
                end.linkTo(boxYellow.start)
            })
        Box(modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                start.linkTo(boxRed.end)
                end.linkTo(boxGreen.start)
            })
        Box(modifier
            .size(50.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(boxYellow.end)
                end.linkTo(parent.end)
            })

        //createHorizontalChain(boxRed, boxYellow, boxGreen, chainStyle = ChainStyle.Packed)
        //createHorizontalChain(boxRed, boxYellow, boxGreen, chainStyle = ChainStyle.Spread)
        createHorizontalChain(boxRed, boxYellow, boxGreen, chainStyle = ChainStyle.SpreadInside)
    }
}

@Composable
fun MyConstraintLayout_text(modifier: Modifier = Modifier) {
    Column(modifier
        .fillMaxSize()
        .padding(vertical = 100.dp)) {
        Text(text = "This is my text example")
        Text(
            "This is my text example",
            color = Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline
        )

        val myStyle = TextStyle(
            color = Color.Red,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline
        )

        Text(
            "This is my text example",
            style = myStyle
        )


    }
}

@Composable
fun MyConstraintLayout_Images(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier
        .fillMaxSize()
        .padding(vertical = 100.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Example",
            alpha = 0.75f,
            //modifier = Modifier.clip(RoundedCornerShape(50f))
            //modifier = Modifier.clip(CircleShape)
            //modifier = Modifier.clip(CircleShape).border(4.dp, Color.Red)
            modifier = Modifier
                .clip(CircleShape)
                .border(4.dp, Color.Red, CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Example",
            alpha = 1f
        )
        Icon(
            imageVector = Icons.Sharp.Star,
            contentDescription = "Icon Example",
            tint = Color.Blue
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        ExercicisStateless(exercici = 3)
    }
}