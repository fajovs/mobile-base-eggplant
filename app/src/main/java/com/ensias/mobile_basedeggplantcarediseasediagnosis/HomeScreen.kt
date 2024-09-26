package com.androidlead.loginappui.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ensias.mobile_basedeggplantcarediseasediagnosis.R
import com.ensias.mobile_basedeggplantcarediseasediagnosis.Routes
import com.ensias.mobile_basedeggplantcarediseasediagnosis.ui.theme.PrimaryGreen
import com.ensias.mobile_basedeggplantcarediseasediagnosis.ui.theme.PrimaryGreenDark
import com.ensias.mobile_basedeggplantcarediseasediagnosis.ui.theme.PrimaryViolet

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    0f to PrimaryViolet,
                    1f to PrimaryGreen
                )
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.camera),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.weight(.2f))
        ActionButton(onClick = { navController.navigate(Routes.diagnoseHistoryPage) }, "Diagnose History")
        Spacer(modifier = Modifier.weight(.2f))
        ActionButton(onClick = { navController.navigate(Routes.plantPage)  }, "My Plant")
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ActionButton(onClick: () -> Unit, text : String) {
    ElevatedButton(
        elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
        onClick = onClick,
        modifier = Modifier
            .width(220.dp)
            .height(80.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryGreenDark,
            contentColor = Color.White
        )

    ) {
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}
