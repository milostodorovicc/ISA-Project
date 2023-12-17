
$(document).ready(function () {

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
            // right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },

        events: function (start, end, timezone, callback) {


            var formattedStart = start.format('YYYY-MM-DD HH:mm:ss');
            var formattedEnd = end.format('YYYY-MM-DD HH:mm:ss');
            $.ajax({
                type: "GET",
                url: 'http://localhost:8011/api/adminsistema/svitermini',
                dataType: 'json',
                data: {
                    start: formattedStart,
                    end: formattedEnd

                },
                success: function (response) {
                    var events = response.map(function (event) {
                        return {
                            id: event.id,
                            title: event.title,
                            start: event.startTime,
                            end: event.endTime,
                            imekorisnikarez: event.imekorisnikarez,
                            prezimekorisnikarez: event.prezimekorisnikarez
                        };
                    });
                    callback(events);
                }
            });
        },
        eventRender: function (event, element) {

            element.find('.fc-title').append('<br/><span class="additional-info">' +
              'Ime:' +   event.imekorisnikarez + 'Prezime:' + event.prezimekorisnikarez + '</span>');



        }



    });
});