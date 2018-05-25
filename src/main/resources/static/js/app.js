function swalConfirm(warningText,confirmBtnText,cancelBtnText,callback){
    if(warningText==""){
        warningText="确认要删除吗？"
    }
    if(confirmBtnText==""){
        confirmBtnText="确定";
    }
    if(cancelBtnText==""){
        cancelBtnText="取消";
    }
    var img="";
    img=basePath+"/images/question.png";

    swal({
            title:"",
            text: warningText,
            imageUrl :img,
            imageSize : "70x70",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: confirmBtnText,
            cancelButtonText:cancelBtnText,
            closeOnConfirm: false
        },
        function(confirm){
            if(confirm){
                callback();

            }

        });
}

/**
 * 后台传递的JSON分页对象，包含相关分页数据
 * 此方法作用为相关总页数，每页显示数参数的设置和页面展示
 * @param pageInfo
 */
function loadPageInfo(pageInfo){
    var firstPageStr="<li onclick='Page(1,"+pageInfo.pageSize+");'><a href='javascript:;'>首页</a></li>";
    var prePageStr="";
    if(pageInfo.prePage==0){
        prePageStr="<li class='disabled' onclick='Page("+pageInfo.prePage+","+pageInfo.pageSize+");'><a href='javascript:;'>上一页</a></li>";
    }else{
        prePageStr="<li onclick='Page("+pageInfo.prePage+","+pageInfo.pageSize+");'><a href='javascript:;'>上一页</a></li>";
    }
    var nextPageStr="";
    if(pageInfo.nextPage==0){
        nextPageStr="<li class='disabled' onclick='Page("+pageInfo.nextPage+","+pageInfo.pageSize+");'><a href='javascript:;'>下一页</a></li>";
    }else{
        nextPageStr="<li onclick='Page("+pageInfo.nextPage+","+pageInfo.pageSize+");'><a href='javascript:;'>下一页</a></li>";
    }
    var lastPageStr="<li onclick='Page("+pageInfo.pages+","+pageInfo.pageSize+");'><a href='javascript:;'>末页</a></li>";
    var pageStr="";
    $(pageInfo.navigatepageNums).each(function(i,item){
        if(item==pageInfo.pageNum){
            pageStr=pageStr+"<li onclick='Page("+item+","+pageInfo.pageSize+")' class='active'><a href='javascript:;'>"+item+"</a></li>";
        }else{
            pageStr=pageStr+"<li onclick='Page("+item+","+pageInfo.pageSize+")'><a href='javascript:;'>"+item+"</a></li>";
        }
    });
    var totalPageStr=firstPageStr+prePageStr+pageStr+nextPageStr+lastPageStr;
    $(".pagination").empty();
    $(".pagination").append(totalPageStr);
}

/**
 * 提示插件
 * @param title
 * @returns
 */
function loading(title) {
    if(title==""){
        title="加载中...";
    }
    $('body').loading({
        selector: 'body',
        loadingWidth:240,
        title:title,
        name:'bodyMsg',
        discription:'...',
        direction:'column',
        type:'origin',
        originBg:'rgba(120, 124, 123, 0.67)',
        originDivWidth:40,
        originDivHeight:40,
        originWidth:6,
        originHeight:6,
        smallLoading:false,
        loadingBg:'rgba(120, 124, 123, 0.67)',
        loadingMaskBg:'rgba(123,122,222,0.2)'
    });
}


/**
 * 根据条件判断显示值
 * @param condition
 * @param val1
 * @param val2
 * @returns {*}
 */
function ifTrue(condition,val1,val2){
    if(condition){
        return val1;
    }
    return val2;
}
function timeExchange(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }

    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    return y+"-"+m+"-"+d;
}

function timeChange(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }

    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h = data.getHours();
    var min = data.getMinutes();
    var s=data.getSeconds();
    return h+":"+min+":"+s;
}

function timeExchangeHM(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }
    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h = data.getHours();
    var min = data.getMinutes();
    return y + "-" + m + "-" + d + " " + h + ":" + min;
}


function timeExchangeHMS(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }
    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h = data.getHours();
    var min = data.getMinutes();
    var s=data.getSeconds();
    return y + "-" + m + "-" + d + " " + h + ":" + min + ":"+s;
}

/**
 * 将秒数换成时分秒格式
 * @param second 秒
 * @example 60 1分钟
 */
function secondExchangeHMS(second) {
    var secondTime = second;// 秒
    var minuteTime = 0;// 分
    var hourTime = 0;// 小时
    if(secondTime >= 60) {
        minuteTime = secondTime / 60;
        secondTime = secondTime % 60;
        if(minuteTime > 60) {
            hourTime = minuteTime / 60;
            minuteTime = minuteTime % 60;
        }
    }
    var result = "";
    if(secondTime > 0) {
        result = "" + secondTime + "秒";
    }
    if(minuteTime > 0) {
        result = "" + minuteTime + "分" + result;
    }
    if(hourTime > 0) {
        result = "" + hourTime + "小时" + result;
    }
    return result;
}

function demandStatusExchange(status) {
    if(status == 0) {
        return '已保存';
    }
    if(status == 1) {
        return '正常';
    }
    if(status == 2) {
        return '匹配成功';
    }
    if(status == 3) {
        return '已失效';
    }
    
}