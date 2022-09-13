$(function() {
	getJson();
});

function getJson() {
	$.getJSON("json/lib.json", function(data){
		$.each(data, function(key, val) {
			if(key=="DESCRIPTION") {
				$("table").attr("border", "1");
				
				$("thead").append(
					"<tr>"+
						"<th>"+val.GU_CODE+"</th>"+
						"<th>"+val.LBRRY_SEQ_NO+"</th>"+
						"<th>"+val.LBRRY_NAME+"</th>"+
						"<th>"+val.ADRES+"</th>"+
						"<th>"+val.TEL_NO+"</th>"+
						"<th>"+val.HMPG_URL+"</th>"+
					"</tr>"
				);
			} else {
				var list = val;
				for(var i = 0; i < list.length; i++) {
					var str = list[i];
					$("tbody").append(
						"<tr>"+
							"<td>"+str.gu_code+"</td>"+
							"<td>"+str.lbrry_seq_no+"</td>"+
							"<td>"+str.lbrry_name+"</td>"+
							"<td>"+str.adres+"</td>"+
							"<td>"+str.tel_no+"</td>"+
							"<td>"+str.hmpg_url+"</td>"+
							// db에 값들을 '/'로 나눠서 넘겨줌
							"<input type='hidden' name='lib' value='"+
							str.gu_code+"/"+str.lbrry_seq_no+"/"+str.lbrry_name+"/"+str.adres+"/"+str.tel_no+"/"+str.hmpg_url+"'>'"+
						"</tr>"
					);
				}
			}
		});
	});
};
