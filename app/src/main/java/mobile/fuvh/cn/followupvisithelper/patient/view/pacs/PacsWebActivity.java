package mobile.fuvh.cn.followupvisithelper.patient.view.pacs;

import android.content.Context;
import android.content.Intent;

/**
 *
 * @author sugar
 * @date 2018/1/4
 *
 */

public class PacsWebActivity extends BaseWebActivity{


    private static String TAG = "PacsWebActivity";

    public static void launch(Context context,String jcybid){
        Intent intent = new Intent(context, PacsWebActivity.class);
        context.startActivity(intent);
    }

    @Override
    public String getUrl() {
        return "https://viewer-wpacs.rubikstack.com/series.html?accessionNumber=CTZY1583473&institution=26b8d8c566d811e7af980242af104d37#/";
    }

    @Override
    public String setTitle() {
        return "影像查看";
    }

    @Override
    protected Class getViewModelClass() {
        return null;
    }
}
