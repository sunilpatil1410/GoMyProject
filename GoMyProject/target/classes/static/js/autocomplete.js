jQuery(document).ready(function($) {
	jQuery('#client').change(function(event) {
			alert(" inside client ");
			console.log("inside client");
		});
	
	
	jQuery('#client').change(function(event) {		
		//let clientLength = $('#client').val().length;
		//console.log(clientLength);
		if( $('#client').val() == "" ){
			$("#clientId").val("");
		}	
	});
});