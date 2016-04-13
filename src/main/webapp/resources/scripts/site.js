$().ready(function () {

    var $rows = $('table tr.booking');

    jQuery.validator.setDefaults({
        debug: false,
        success: "valid"
    });

    $(".bookingForm").validate({
        rules: {
            restaurantId: "required",
            date: {
                required: true,
                estonianDate: true,
                futureDate: true
            },
            duration: {
                required: true,
                number: true,
                min: 0.1,
                max: 99.9
            },
            count: {
                required: true,
                digits: true,
                min: 1,
                max: 50
            },
            contactMethod: "required",
            contactName: {
                required: true,
                minlength: 2,
                maxlength: 50
            },
            contactPhoneNumber: {
                digits: true,
                minlength: 5,
                maxlength: 10
            },
            comments: {
                maxlength: 500
            }
        },
        messages: {
            restaurantId: "Choose restaurant!",
            date: {
                required: "Pick date and time!",
            },
            duration: {
                max: "The number is too big."
            }
        }
    });

    $(".restaurantForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 30
            },
            aadress: {
                required: true,
                minlength: 5,
                maxlength: 100
            }
        },
        messages: {
            name: {
                required: "Restaurant's name is required. Field cannot be empty!",
                minlength: "Restaurant's name must be at least 3 characters long.",
                maxlength: "Restaurant's name must be at most 30 characters long."
            },
            aadress: {
                required: "Restaurant's address is required. Field cannot be empty!",
                minlength: "Restaurant's address must be at least 5 characters long.",
                maxlength: "Restaurant's address must be at most 100 characters long."
            }
        }
    });

    $('#search').keyup(function () {
        $rows = $('table tr');
        var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
        $rows.show().filter(function () {
            var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
            return !~text.indexOf(val);
        }).hide();
    });

    $(function () {
        if ($('*[name=startDate]').length) {
            var restaurants = localStorage.getItem("restaurant");
            if (restaurants !== null) {
                $("input[name='restaurantId']").attr("checked", "checked");
            }
            filterRows();
        }
        var columnNumbers = [0, 0, 0, 0, 0, 0, 0];
        $('.bookingStatistics tr:gt(0)').each(function () {
            for (var j = 2; j <= 8; j++) {
                var number = parseInt($(this).text().split('\n')[j]);
                if (number >= 0) {
                    columnNumbers[j - 2] += number;
                }
            }
        });
        for (var k = 0; k < columnNumbers.length; k++) {
            document.getElementById("weekDay" + k).innerHTML = columnNumbers[k];
        }
    });

    $("input[name='restaurantId']").click(function () {
        if ($(this).is(":checked")) {
            localStorage.setItem("restaurant", $(this).val());
        } else {
            localStorage.removeItem("restaurant");
        }
    });

    $('#startDate').bind('click keyup', filterRows);

    $('#endDate').bind('click keyup', filterRows);

    $('*[name=restaurantId]').bind('click keyup', filterRows);

    $('*[name=date]').appendDtpicker({
        "minuteInterval": 15,
        "futureOnly": true,
        "firstDayOfWeek": 1,
        "dateFormat": "DD-MM-YYYY hh:mm",
        "minTime": "09:00",
        "maxTime": "23:00",
        "autodateOnStart": false,
        // "current": $('*[name=date]').val(),
        "locale": "et"
    });

    $('#startDate').appendDtpicker({
        "futureOnly": true,
        "firstDayOfWeek": 1,
        "dateFormat": "DD-MM-YYYY",
        "dateOnly": true,
        "locale": "et"
    });

    $('#endDate').appendDtpicker({
        "futureOnly": true,
        "firstDayOfWeek": 1,
        "dateFormat": "DD-MM-YYYY",
        "dateOnly": true,
        "locale": "et"
    });

    $('.one-digit').keyup(function () {
        this.value = this.value.replace(/,/g, ".");
        if ($(this).val().indexOf('.') != -1) {
            if ($(this).val().split(".")[1].length > 1) {
                if (isNaN(parseFloat(this.value))) return;
                this.value = parseFloat(this.value).toFixed(1);
            }
        }
        return this;
    });

    $('.zero-digit').keyup(function () {
        this.value = this.value.replace(/,/g, ".");
        if ($(this).val().indexOf('.') != -1) {
            if ($(this).val().split(".")[1].length > 0) {
                if (isNaN(parseFloat(this.value))) return;
                this.value = parseFloat(this.value).toFixed(0);
            }
        }
        return this;
    });

    $.validator.addMethod(
        "estonianDate",
        function (value, element) {
            return value.match(/^\d\d?\-\d\d?\-\d\d\d\d?\ \d\d?\:\d\d$/);
        },
        "Please enter a date in the format dd-mm-yyyy hh:mm."
    );

    $.validator.addMethod(
        "futureDate",
        function (value, element) {
            var date = value.split(' ')[0].split('-');
            var time = value.split(' ')[1].split(':');
            return new Date(date[2], date[1], date[0], time[0], time[1]) > new Date();
        },
        "Please enter a date in the future."
    );

    function addZeroBefore(number) {
        return number < 10 ? "0" + number : number;
    }

    function formatDate(date) {
        return addZeroBefore(date.getDate()) + "-" + addZeroBefore(date.getMonth() + 1) + "-" + date.getFullYear();
    }

    function filterRows() {
        console.log('started filterRows');
        $rows.hide();
        var start = $('#startDate').handleDtpicker('getDate'),
            end = $('#endDate').handleDtpicker('getDate'),
            currentDate = new Date(start),
            between = [];
        while (currentDate <= end) {
            between.push(formatDate(currentDate));
            currentDate.setDate(currentDate.getDate() + 1);
        }
        var checkedRestaurants = getCheckedRestaurants($(document));
        $rows.each(function (index) {
            if (index !== 0) {
                $row = $(this);
                var restaurant = $row.find("td:eq(0)").text();
                var date = $row.find("td:eq(1)").text().split(' ')[0];
                if (jQuery.inArray(date, between) == -1 || jQuery.inArray(restaurant, checkedRestaurants) == -1) {
                    $row.hide();
                } else {
                    $row.show();
                }
            }
        });
    }

    function getCheckedRestaurants(doc) {
        var checkedRestaurants = doc
            .find('input[type=checkbox]:checked')
            .map(function () {
                return {
                    name: $(this).val()
                };
            })
            .get();
        var restaurants = [];
        for (var i = 0; i < checkedRestaurants.length; i++) {
            restaurants.push(checkedRestaurants[i].name);
        }
        return restaurants;
    }

});
