/*
 * Admin panel modules initialization.
 * 
 * @author Łukasz Pawełczak
 */


$(document).ready(function() {
	
	
	/*
	 * Hide alert messages after period of time.
	 */
	var hideAlert = function($alertBox) {
		var $this = $alertBox;
		setTimeout(function() {
			$this.slideUp("slow", function() {
				$(this).remove();
			});
		}, 6000);
	};

	$(".alert").each(function() {
		hideAlert($(this));
		
		//removeParam("color_id", originalURL);
	});
	
	
	
	$("[data-toggle='confirmation-popup']").each(function() {
		var $this = $(this);
		
		$(this).popConfirm({
			title: $this.attr("data-title"),
			placement: $this.attr("data-placement"),
	        container: "body", // The html container
	        yesBtn: $this.attr("data-btn-yes"),
	        noBtn: $this.attr("data-btn-no")
		});
		
	});
	
});

