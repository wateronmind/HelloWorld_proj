/**
 * jQuery 기능은 이곳에 작성
 */
;(function($){ 
    'use strict';

    // 메인 - 항공권 검색, 호텔 검색 전환
    function changeSearch() {
        let $bookingBox = $('.booking-box');
        let $flight = $('.button', $bookingBox).eq(0);
        let $hotel = $('.button', $bookingBox).eq(1);
        
        let $flightForm = $('.flight-srch', $bookingBox);
        let $hotelForm = $('.hotel-srch', $bookingBox);

        $flight.on('click', function(e){
            e.preventDefault();
            $(this).addClass('on');
            $hotel.removeClass('on');
            $flightForm.show();
            $hotelForm.hide();
        });

        $hotel.on('click', function(e){
            e.preventDefault();
            $(this).addClass('on');
            $flight.removeClass('on');
            $flightForm.hide();
            $hotelForm.show();
        });
    }
    changeSearch();
})(jQuery);