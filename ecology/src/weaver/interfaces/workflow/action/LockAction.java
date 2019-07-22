package weaver.interfaces.workflow.action;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.soa.workflow.request.RequestInfo;

/**
 * Created by zfm on 2017-12-14.
 * /**限制入库流程和交易流程的提交
 *
 */
public class LockAction  implements Action {
    BaseBean baseBean=new BaseBean();
    RecordSet rs=new RecordSet();


    @Override
    public String execute(RequestInfo requestInfo) {

        return SUCCESS;
    }



    public  boolean lock() {
        boolean flag = false;
        //查询盘点流程是否存在未归档的sql语句
        String selectWorkflow = "select requestid from workflow_requestbase where  currentnodetype!=3 and workflowid=22181 ";
        baseBean.writeLog("打印出查询是否存在未归档的盘点流程：" + selectWorkflow);
        rs.executeSql(selectWorkflow);
        while (rs.next()) {
            flag = true;
        }
        if (flag) {
            return false;
        }
        return false;
    }
}
