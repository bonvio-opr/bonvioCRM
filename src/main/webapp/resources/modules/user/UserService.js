function UserService($http) {
    this.getUsers = function () {
        return $http.get("user/getUsers").then(function (responce) {
            if (responce.status == 200) return responce.data;
        });
    };
}

angular
    .module("staff")
    .service("UserService", UserService);