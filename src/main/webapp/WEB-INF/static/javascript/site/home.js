$(document).ready(function() {

	
	/**
	 * Home page, most popular galleries, last added galleries
	 * title & description text cut
	 * 
	 */
	$(".item-title").dotdotdot({
	
	});
	
	$(".item-desc").dotdotdot({
		height: 108
	});
	
	/**
	 * Home page carousel
	 */
	var jssor_slider1 = new $JssorSlider$("slider1_container", { $AutoPlay: true, $AutoPlayInterval: 4000,
        $SlideWidth: 940,
        $SlideHeight: 450,
        $BulletNavigatorOptions: {
            $Class: $JssorBulletNavigator$,
            $ChanceToShow: 2,
            $SpacingX: 6
        },
        $ArrowNavigatorOptions: {
            $Class: $JssorArrowNavigator$,
            $ChanceToShow: 2
        }
    });
	
});

