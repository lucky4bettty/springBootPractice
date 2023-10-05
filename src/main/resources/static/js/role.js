

// 定义 function A
function functionA() {

}

// 立即执行 function A
functionA();

console.log('Function B has been executed!');

function deleteMultiple() {
	console.log('刪除');
	var sn = document.getElementsByName("ids");
	var count = 0;
	for ( var i = 0; i < sn.length; i++) {
		if (sn[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("請勾選刪除項目!");
		return false;
	} else {
		if (confirm("你確定要刪除選取資料?")) {
			document.forms['uForm'].action = 'delete';
			document.forms['uForm'].submit();
		}
	}
}