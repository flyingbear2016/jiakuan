$(function(){
	
	
	/*var param = {'id':"0"};
	$.ajax({
        url : "/citi_log/login/getLoginInfo.action",
        type : 'post',              
        data : param,
        dataType:'json',
        async:true,
    	error :function(xhr, textStatus, error) {
    		console.log(2);
		},
        success:function(data) {
        	console.log(data);
        }
    });*/
	
	$.ajax({
        url : "/citi_log/login/getBalanceList.action",
        type : 'post',              
        data : {},
        dataType:'json',
        async:true,
    	error :function(xhr, textStatus, error) {
    		console.log(2);
		},
        success:function(data) {
        	if(data){
        		var html = '<table border=\"1\" width=\"100%\">'
        			   + '<thead bgcolor="red"><th>id</th><th>余额</th></thead><tbody>';
        		
        		for(var i in data){
        			html +='<tr>';
        			html +='<td>'+data[i].id+'</td>';
        			html +='<td>'+data[i].balance+'</td>';
        			html +='</tr>';
        		}
        		html +='</tbody></table>';
        		
        		$("#balance").html(html);
        	}
        }
    });
	
	/*var params = {'outIds':"0",
	         'inIds':"1",
	         'moneys':"100"
           };
	$.ajax({
        url : "/citi_log/login/transMoney.action",
        type : 'post',              
        data : {'jsonParam':JSON.stringify(params)},
        dataType:'json',
        async:true,
    	error :function(xhr, textStatus, error) {
    		console.log(2);
		},
        success:function(data) {
        	console.log(3);
        }
    });*/
	
});


