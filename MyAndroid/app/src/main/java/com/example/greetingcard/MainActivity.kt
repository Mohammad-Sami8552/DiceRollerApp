package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    BusinessCardApp(
//                        text1 = stringResource(R.string.tasks),
//                        text2 = stringResource(R.string.nice_work),
//                        text3 = stringResource(R.string.end)
                          text1 = stringResource(R.string.jennifier),
                          text2 = stringResource(R.string.developer),
                          text3 = stringResource(R.string.phone),
                          text4 = stringResource(R.string.share),
                          text5 = stringResource(R.string.gmail),
//                          text6 = stringResource(R.string.sixth),
//                          text7 = stringResource(R.string.seventh),
//                          text8 = stringResource(R.string.eighth)

                    )
                }
            }
        }
    }
}
//
////
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun JetpackTutorialsScreen(text1 : String, text2 : String, text3:) {
//    Scaffold(
//        topBar = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp) // Your custom height
//                    .background(Color(0xFF1976D2)), // Blue background
//                contentAlignment = Alignment.CenterStart
//            ) {
//                Text(
//                    text = "Greeting Card",
//                    color = Color.White,
//                    fontSize = 20.sp
//                )
//            }
//        }
//
//    ) { innerPadding ->
//        TaskManager(
//            text1=text1,
//            text2=text2,
//            text3 =text3
//            modifier = Modifier
//                .padding(innerPadding)
//                .padding(0.dp)
//        )
//    }
//}


//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TaskManagerScreen(text1 : String, text2 : String) {
//    Scaffold(
//        topBar = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp) // Your custom height
//                    .background(Color(0xFF1976D2)), // Blue background
//                contentAlignment = Alignment.CenterStart
//            ) {
//                Text(
//                    text = "Task Manager",
//                    color = Color.White,
//                    fontSize = 20.sp
//                )
//            }
//        }
//
//    ) { innerPadding ->
//        TaskManager(
//            text1=text1,
//            text2=text2,
//            modifier = Modifier
//                .padding(innerPadding)
//                .padding(0.dp)
//        )
//    }
//}



//
//@Composable
//fun ComposableBlogs(text1: String, text2: String, text3: String, text4: String, text5: String, text6: String, text7: String, text8: String, modifier: Modifier =Modifier)
//{
//
//    Row (modifier = modifier
//        .padding(16 .dp)) {
//        Column(
//            modifier = modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center
//        ) {
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text1,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
//
//                )
//                Text(
//                    text = text2,
//                    fontSize = 12.sp
//
//                )
//            }
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text3,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
//
//                )
//                Text(
//                    text = text4,
//                    fontSize = 12.sp
//
//                )
//            }
//        }
//        Column(
//            modifier = modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//        ) {
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text5,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
//
//                )
//                Text(
//                    text = text6,
//                    fontSize = 12.sp
//
//                )
//            }
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text7,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//
//
//                    )
//                Text(
//                    text = text8,
//                    fontSize = 12.sp
//
//                )
//            }
//
//        }
//    }
//}

//@Composable
//fun ComposableBlogs(text1: String, text2: String, text3: String, text4: String, text5: String, text6: String, text7: String, text8: String, modifier: Modifier =Modifier)
//{
//
//    Row (modifier = modifier
//        .padding(16 .dp)) {
//        Column(
//            modifier = modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center
//        ) {
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text1,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
//
//                )
//                Text(
//                    text = text2,
//                    fontSize = 12.sp
//
//                )
//            }
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text3,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
//
//                )
//                Text(
//                    text = text4,
//                    fontSize = 12.sp
//
//                )
//            }
//        }
//        Column(
//            modifier = modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//        ) {
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text5,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
//
//                )
//                Text(
//                    text = text6,
//                    fontSize = 12.sp
//
//                )
//            }
//            Column(
//                modifier = modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = text7,
//                    fontWeight = FontWeight.Bold,
//                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//
//
//                    )
//                Text(
//                    text = text8,
//                    fontSize = 12.sp
//
//                )
//            }
//
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ComposableBlogsScreen(text1: String, text2: String, text3: String, text4: String, text5: String, text6: String, text7: String, text8: String, modifier: Modifier =Modifier) {
//    Scaffold(
//        topBar = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(70.dp) // Your custom height
//                    .background(Color(0xFF1976D2)), // Blue background
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Task Manager",
//                    color = Color.White,
//                    fontSize = 20.sp
//                )
//            }
//        }
//
//    ) { innerPadding ->
//        ComposableBlogs(
//            text1=text1,
//            text2=text2,
//            text3=text3,
//            text4=text4,
//            text5=text5,
//            text6=text6,
//            text7=text7,
//            text8=text8,
//            modifier = modifier
//                .padding(innerPadding)
//                .padding(0.dp)
//        )
//    }
//}
//@Composable
//fun ComposableBlogs(text1: String, text2: String, text3: String, text4: String, text5: String, text6: String, text7: String, text8: String,modifier: Modifier =Modifier) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//      horizontalAlignment = Alignment.CenterHorizontally
//
//    ) {
//        Box(
//            modifier = Modifier
//                .weight(1f)
//                .fillMaxWidth()
//                .background(Color(0xFFEADDFF))
//        )
//        {
//            Row(
//                modifier = Modifier.fillMaxSize()
//
//            ) {
//                Box(
//                    modifier = Modifier
//                        .weight(0.5f)
//                        .fillMaxHeight()
//                        .background(Color(0xFFEADDFF))
//                )
//                {
//                    Column(modifier =modifier.fillMaxHeight(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                        Text(
//                            text = text1,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//                            textAlign = TextAlign.Center
//
//                        )
//                            Text(
//                                text = text2,
//                                fontSize = 12.sp,
//                                textAlign = TextAlign.Center
//
//                            )
//
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .weight(0.5f)
//                        .fillMaxHeight()
//                        .background(Color(0xFFD0BCFF)),
//                )
//                {
//                    Column(modifier =modifier.fillMaxHeight(),
//                    verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally) {
//                        Text(
//                            text = text3,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//                            textAlign = TextAlign.Center
//
//                            )
//                        Text(
//                            text = text4,
//                            fontSize = 12.sp,
//                            textAlign = TextAlign.Center
//
//                        )
//                    }
//                }
//
//            }
//        }
//
//
//        Box(
//            modifier = Modifier
//                .weight(1f)
//                .fillMaxWidth()
//                .background(Color(0xFFEADDFF))
//        )
//        {
//            Row(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Box(
//                    modifier = Modifier
//                        .weight(0.5f)
//                        .fillMaxHeight()
//                        .background(Color(0xFFB69DF8)),
//                    contentAlignment = Alignment.Center
//                )
//                {
//                    Column(modifier =modifier.fillMaxHeight(),
//                            verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally) {
//                        Text(
//                            text = text5,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//                            textAlign = TextAlign.Center
//                        )
//                        Text(
//                            text = text6,
//                            fontSize = 12.sp,
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//                Box(
//                    modifier = Modifier
//                        .weight(0.5f)
//                        .fillMaxHeight()
//                        .background(Color(0xFFF6EDFF)),
//
//                    contentAlignment = Alignment.Center
//                )
//                {
//                    Column(modifier =modifier.fillMaxHeight(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            text = text7,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
//                            textAlign = TextAlign.Center
//                        )
//                        Text(
//                            text = text8,
//                            fontSize = 12.sp,
//                            textAlign = TextAlign.Center
//                        )
//                    }
//                }
//
//            }
//
//        }
//    }
//}
@Composable
fun BusinessCardApp(text1: String, text2:String,text3: String,text4: String, text5:String,modifier: Modifier =Modifier)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
        .background(Color.Green.copy(alpha = 0.30f))
    ) {
        Spacer(modifier =modifier.padding(0.dp, 100.dp) )
        Title(
            text1 =text1,
            text2 =text2,
        )
        Spacer(modifier =modifier.padding(0.dp, 150.dp) )
        ContactInfo(
            text3 =text3,
            text4 =text4,
            text5 =text5
        )
    }
}
@Composable
fun Title(text1: String, text2:String,modifier: Modifier =Modifier)
{
    val image = painterResource(R.drawable.android_logo)
    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier =modifier.height(120 .dp)
                .background(Color.Black)
        )
        Text(
            text =text1,
            fontWeight = FontWeight.Bold,
            fontSize = 40 .sp

        )
        Text(
            text =text2,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E7D32)
        )
    }

}

@Composable
fun ContactInfo(text3: String, text4:String,text5: String,modifier: Modifier =Modifier)
{
    Column {

        Row {
            Spacer(modifier = modifier.padding(80. dp, 0.dp, 0.dp, 0.dp))
            Box(modifier = Modifier
                .weight(1f)

                 ) {

                Icon(
                    painter = painterResource(R.drawable.call),
                    contentDescription = null,
                    tint = Color(0xFF2E7D32)

                )
            }
            Box(modifier = Modifier
                .weight(6f)
                 ) {
                Text(
                    text = text3,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        Row {
            Spacer(modifier = modifier.padding(80. dp, 0.dp, 0.dp, 0.dp))
            Box(modifier = Modifier
                .weight(1f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.share),
                    contentDescription = null,
                    tint = Color(0xFF2E7D32)

                )
            }
            Box(modifier = Modifier
                .weight(6f)
               ) {
                Text(
                    text = text4,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        Row {
            Spacer(modifier = modifier.padding(80. dp, 0.dp, 0.dp, 0.dp))
            Box(modifier = Modifier
                .weight(1f)

            ) {
                Icon(
                    painter = painterResource(R.drawable.mail),
                    contentDescription = null,
                    tint = Color(0xFF2E7D32)

                )
            }
            Box(modifier = Modifier
                .weight(6f)
                ) {
                Text(
                    text = text5,
                    fontWeight = FontWeight.Bold

                )
            }
        }

        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        BusinessCardApp(
            stringResource(R.string.jennifier), stringResource(R.string.developer),
            stringResource(R.string.phone), stringResource(R.string.share),
            stringResource(R.string.gmail)
        )

    }
}


//
//    @Preview(showBackground = true, showSystemUi = true)
//    @Composable
//    fun GreetingPreview() {
//        HappyBirthdayTheme {
//            ComposableBlogs(
//                stringResource(R.string.first), stringResource(R.string.second),
//                stringResource(R.string.third), stringResource(R.string.fourth),
//                stringResource(R.string.fifth), stringResource(R.string.sixth),
//                stringResource(R.string.seventh), stringResource(R.string.eighth)
//            )
//
//        }
//    }



//@Composable
//fun TaskManager(text1: String, text2: String, modifier: Modifier =Modifier)
//{
//    val image = painterResource(R.drawable.ic_task_completed)
//    Column(modifier = modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally) {
//
//        Image(
//            painter = image,
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
//
//        Text(
//            text = text1,
//            fontWeight = FontWeight.Bold,
//            modifier = modifier
//                .padding(24.dp, 0 .dp, 8 .dp, 0.dp)
//        )
//        Text(
//            text = text2,
//            fontSize = 16.sp
//        )
//
//    }
//
//}

//@Composable
//fun JetpackTutorials(text1 : String, text2 : String, text3: String, modifier: Modifier = Modifier) {
//    val image= painterResource(R.drawable.bg_compose_background)
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = image,
//            contentDescription = null,
//            contentScale =  ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(145 .dp),
//
//        )
//
//        Text(
//            text = text1,
//            fontSize = 24.sp,
//            modifier = Modifier
//                .padding(16. dp),
//
//        )
//        Text(
//            text = text2,
//            modifier = Modifier
//                .padding(16.dp),
//            textAlign = TextAlign.Justify
//        )
//        Text(
//            text = text3,
//            modifier = Modifier.padding(16 .dp),
//            textAlign = TextAlign.Justify
//        )
//    }
//}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    HappyBirthdayTheme {
//        JetpackTutorialsScreen(stringResource(R.string.jetpackc), stringResource(R.string.middle),
//            stringResource(
//                R.string.end
//            )
//        )
//    }
//}

    //@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    HappyBirthdayTheme {
//        TaskManagerScreen(
//            stringResource(R.string.tasks), stringResource(R.string.nice_work)
//        )
//    }
//}




