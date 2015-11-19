function TicketService($http) {
    this.getTickets = function () {
        return $http.get("ticket/getTickets").then(function (response) {
            console.log(response.data.length);
            if (response.status == 200) return response.data;
        });
    };

    this.insertTicket = function (ticket) {
        return $http.post("ticket/insertTicket", ticket).then(function (response) {
            if (response.status == 200) return response.data;
        });
    };

    this.deleteTicketById = function (ticketId) {
        return $http.delete("ticket/deleteTicketById/" + ticketId).then(function (response) {
            if (response.status == 200) return response.data;
        });
    };

    this.updateTicket = function (ticket) {
        console.log(ticket);
        //ticket.developerId = ticket.developer.id;
        //delete ticket.developer;
        //console.log(ticket);
        return $http.put("ticket/updateTicket", ticket).then(function (response) {
            if (response.status == 200) return response.data;
        });
    }
}

angular
    .module("staff")
    .service("TicketService", TicketService);