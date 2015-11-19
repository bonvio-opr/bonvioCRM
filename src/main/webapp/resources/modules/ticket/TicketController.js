function TicketController(TicketService, UserService) {
    var ticket = this;
    ticket.list = [];
    ticket.single = {};
    ticket.getTickets = function () {
        TicketService.getTickets().then(function (data) {
            ticket.list = data.reverse();
        });

        ticket.getUsers();
    };
    ticket.insertTicket = function() {
        TicketService.insertTicket(ticket.single).then(function (data) {
            ticket.list.unshift(data);
        });

        ticket.single = {};
    };
    ticket.deleteTicket = function (single) {
        TicketService.deleteTicketById(single.id).then(function (data) {
            ticket.list.splice(ticket.list.indexOf(single), 1)
        });
    };

    ticket.userList = [];
    ticket.getUsers = function () {
        UserService.getUsers().then(function (data) {
            ticket.userList = data;
        });
    };

    ticket.updateTicket = function (single, status) {
        single.status = status;
        TicketService.updateTicket(single);
    }
}

angular
    .module("staff")
    .controller("TicketController", TicketController);