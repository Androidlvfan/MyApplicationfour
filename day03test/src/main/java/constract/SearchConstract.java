package constract;

import java.util.HashMap;
import bean.SearchBean;
import model.SearchModel;

public interface SearchConstract {
    /**
     * p
     */
    public abstract class SearchPresneter{
        public abstract void show(HashMap<String,String> params);
    }
    /**
     * m
     */
    public interface SearchModel{
        void show(HashMap<String,String> params, model.SearchModel.ModelCallBack modelCallBack);
    }
    /**
     * v
     */
    public interface SearchView{
        void Success(String result);
        void FailUre(String msg);
    }
}
