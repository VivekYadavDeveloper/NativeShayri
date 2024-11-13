package com.create.shayri

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.create.shayri.Model.ShayariModel
import com.create.shayri.ui.theme.primaryLight


@Composable
@Preview
fun DemoPreviewsToolBar(modifier: Modifier = Modifier) {
    MainToolBar("Category", { })
}

@Composable
fun MainToolBar(title: String, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Card(
            modifier = Modifier
                .size(40.dp)
                .clickable { onClick.invoke() },
            colors = CardDefaults.cardColors(containerColor = primaryLight),
            shape = RoundedCornerShape(50)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title, fontSize = 18.sp, style = TextStyle(color = Color.White))
    }
}

fun getListOfCategory(): List<ShayariModel> {
    return listOf<ShayariModel>(
        ShayariModel(
            "Love", listOf(
                "तुमसे मोहब्बत करना मेरा सबसे अच्छा फैसला था।",
                "तुम्हारी हँसी मेरी जिंदगी का सबसे खूबसूरत हिस्सा है।",
                "तेरे बिना मैं अधूरा हूँ, तू है तो मैं पूरा हूँ।",
                "तू मेरे दिल की धड़कन है, मेरे हर लम्हे की ख्वाहिश है।",
                "तुमसे मिलकर ऐसा लगता है जैसे खुदा ने मेरी हर दुआ कबूल कर ली।",
                "तेरे इश्क में खुद को मैं खोने लगा हूँ, जैसे तेरे बिन कुछ और न होना चाहिए।",
                "तेरी बाहों में ऐसा सुकून है कि हर दर्द भूल जाता हूँ।",
                "मेरा दिल भी तुझसे ही शुरू होता है और तुझ पर ही खत्म।",
                "तेरे इश्क में ये दिल सब कुछ भुला बैठा है, अब तो मुझे खुद का होश नहीं।",
                "तू मेरा ख्वाब है, हर लम्हा तुझसे ही शुरू होता है।",
                "तू है तो जिंदगी खूबसूरत है, तेरे बिना हर खुशी अधूरी है।"
            )
        ),
        ShayariModel(
            "Friendship", listOf(
                "दोस्ती वो नहीं जो मिट जाए, दोस्ती वो नहीं जो खत्म हो जाए।",
                "सच्चे दोस्त कभी साथ नहीं छोड़ते, चाहे कुछ भी हो जाए।",
                "दोस्ती का रिश्ता ऐसा होता है, जो हर मोड़ पर साथ देता है।",
                "असली दोस्त वही है, जो मुश्किलों में काम आए।",
                "दोस्ती जिंदगी का सबसे खूबसूरत एहसास है।",
                "सच्चे दोस्त वो होते हैं, जो हमारे दुख में साथ रहते हैं।",
                "जिंदगी में दोस्त का होना किसी वरदान से कम नहीं।",
                "दोस्ती में छल कपट नहीं होता, सच्चा दोस्त हमेशा साथ होता है।",
                "दोस्ती में मोहब्बत होती है, सच्ची और बिना शर्त के।",
                "सच्चे दोस्त वही हैं जो हमारी कमियों को भी समझते हैं।",
                "दोस्ती का मतलब भरोसा और प्यार होता है।",
                "दोस्ती की अहमियत वही समझता है जिसने दोस्त खो दिया हो।"
            )
        ),
        ShayariModel(
            "Life", listOf(
                "जिंदगी एक अनमोल तोहफा है, इसे जियो।",
                "हर दिन को अपने आखिरी दिन की तरह जियो।",
                "जिंदगी का हर लम्हा कुछ न कुछ सिखाता है।",
                "मुश्किलों से डर कर भागना नहीं, सामना करना सीखो।",
                "जिंदगी का असली मजा संघर्ष में है।",
                "हर दिन एक नई शुरुआत है, इसे खुशी से जीना चाहिए।",
                "जिंदगी में उतार-चढ़ाव आते रहते हैं, लेकिन हमें मुस्कुराना नहीं छोड़ना चाहिए।",
                "जो लोग जिंदगी में मेहनत करते हैं, वही सफलता पाते हैं।",
                "जिंदगी को समझने के लिए जीना जरूरी है।",
                "जिंदगी में सब कुछ खुद पर निर्भर करता है।",
                "हर खुशी का मतलब पैसा नहीं होता, सुकून भी जरूरी है।",
                "जिंदगी हर पल कुछ न कुछ नया सीखाती है।",
                "जिंदगी का असली मकसद खुद को जानना और समझना है।"
            )
        ),
        ShayariModel(
            "Motivation", listOf(
                "खुद को कमजोर समझना सबसे बड़ा अपराध है।",
                "सपने देखो और उन्हें सच करने के लिए मेहनत करो।",
                "जब तक हार नहीं मानते, तब तक आप हारे नहीं हैं।",
                "जो मेहनत से नहीं डरते, वही अपने लक्ष्य को पाते हैं।",
                "हर मुश्किल के पीछे एक नया अवसर छिपा होता है।",
                "हिम्मत मत हारो, सफर कठिन हो सकता है पर मंज़िल खूबसूरत होगी।",
                "हर नई सुबह एक नई उम्मीद लेकर आती है।",
                "अपने सपनों के पीछे भागो, सफलता खुद तुम्हारे पीछे आएगी।",
                "हार मानने से पहले एक बार और कोशिश जरूर करो।",
                "जो खुद पर विश्वास रखते हैं, वो ही दुनिया बदलते हैं।",
                "असफलता से मत घबराओ, यही सफलता का पहला कदम है।",
                "मंजिल उन्हीं को मिलती है जो मेहनत का सफर तय करते हैं।"
            )
        ),
        ShayariModel(
            "Sadness", listOf(
                "जख्म कहां दिखते हैं, ये दिल से पूछो।",
                "जिंदगी ने जो जख्म दिए हैं, वो अब दर्द नहीं देते।",
                "हर मुस्कान के पीछे एक दर्द छिपा होता है।",
                "किसी के दर्द को समझना आसान नहीं होता।",
                "जब अपने ही साथ छोड़ देते हैं, तब अकेलापन घेर लेता है।",
                "दर्द को समझने वाला कोई नहीं होता, सब अपनी खुशी में रहते हैं।",
                "जिंदगी में अकेले चलना सीखना पड़ता है।",
                "कभी-कभी दिल को समझाना मुश्किल हो जाता है।",
                "दर्द को खुद में ही सहने की आदत हो गई है।",
                "किसी के बिना भी जीना सीखना पड़ता है।",
                "दर्द की वजह किसी को नहीं बताई जाती, खुद ही सहना पड़ता है।",
                "कभी-कभी खुद से ही लड़ाई करनी पड़ती है।",
                "आंसू वो दर्द हैं जो दिखते नहीं, बस अंदर ही अंदर बहते रहते हैं।"
            )
        )
    )


}