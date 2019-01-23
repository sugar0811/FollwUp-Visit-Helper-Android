package mobile.fuvh.cn.followupvisithelper.voice.helper;

import android.content.Context;
import android.text.TextUtils;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.voice.widget.IChatView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemChartView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemDiseaseCaseView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemDiseaseDetailView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemVoice2TextView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemWardRoundView;

/**
 *
 * @author sugar
 * @date 2018/12/14
 */

public class ChatHelper {

    public static String[] keyWorkCase = {"病例","病历"};
    public static String[] keyWorkZhibiao = {"白细胞","红细胞","细胞","检验"};
    public static String keyWorkWardRound = "查房";
    public static String[] keyWorkDiseaseRecord = {"病程","病程记录"};

    public static IChatView parseQ(String question, Context context){
        IChatView answerView = null;
        if(!TextUtils.isEmpty(question)){
            if(isContain(question,keyWorkCase)){
                answerView = new ItemDiseaseCaseView(context);
            }else if(isContain(question,keyWorkZhibiao)){
                answerView = new ItemChartView(context);
            }else if(isContain(question,keyWorkDiseaseRecord)){
                answerView = new ItemDiseaseDetailView(context);
            } else if(question.contains(keyWorkWardRound)){
                answerView = new ItemWardRoundView(context);
            } else{
                ItemVoice2TextView itemVoice2TextView = new ItemVoice2TextView(context);
                itemVoice2TextView.text(CommonUtils.getString(R.string.chat_tip_none));
                itemVoice2TextView.left();
                answerView = itemVoice2TextView;
            }

        }

        return answerView;


    }

    private static boolean isContain(String question,String[] keyWords) {
        for (String s : keyWords) {
            if(question.contains(s)) {
                return true;
            }
        }
        return false;
    }


    public static ItemVoice2TextView getRightTextView(Context context,String str){
        ItemVoice2TextView itemVoice2TextView = new ItemVoice2TextView(context);
        itemVoice2TextView.text(str);
        itemVoice2TextView.right();
        return itemVoice2TextView;
    }


}
