package presenter;

import java.util.HashMap;

import bean.SearchBean;
import constract.SearchConstract;
import model.SearchModel;

public class SearchPresenter extends SearchConstract.SearchPresneter {
   private SearchModel searchModel;
   private SearchConstract.SearchView searchView;

    public SearchPresenter(SearchConstract.SearchView searchView) {
        this.searchModel = new SearchModel();
        this.searchView = searchView;
    }

    @Override
    public void show(HashMap<String, String> params) {
        if(searchModel != null){
            searchModel.show(params, new SearchModel.ModelCallBack() {

                @Override
                public void Success(String result) {
                    searchView.Success(result);
                }

                @Override
                public void FailUre(String msg) {
                    searchView.FailUre(msg);
                }
            });
        }
    }
}
