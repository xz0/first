System.register(['angular2/core', "./service/user.service"], function(exports_1) {
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, user_service_1;
    var UserListComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (user_service_1_1) {
                user_service_1 = user_service_1_1;
            }],
        execute: function() {
            UserListComponent = (function () {
                function UserListComponent(userService) {
                    this.userService = userService;
                    this.title = 'Tour of Heroes';
                }
                UserListComponent.prototype.ngOnInit = function () {
                    this.getPos();
                    console.log("this.users2:" + JSON.stringify(this.users));
                };
                UserListComponent.prototype.getPos = function () {
                    var _this = this;
                    this.userService.getPos().subscribe(function (users) { return _this.users = users; }, function (error) { return _this.errorMessage = error; });
                };
                UserListComponent.prototype.createPo = function () {
                    this.selectedUser = null;
                };
                UserListComponent.prototype.updatePo = function (i, user) {
                    this.selectedUser = user;
                    this.updateIndex = i;
                };
                UserListComponent.prototype.deletePo = function (i, id) {
                    var _this = this;
                    this.userService.deletePo(id).subscribe(function (resultPo) { return resultPo.id = 1; }, function (error) { return _this.errorMessage = error; });
                    this.users.splice(i, 1);
                };
                UserListComponent.prototype.onSubmit = function (data) {
                    var _this = this;
                    if (data.id) {
                        this.userService.updatePo(data).subscribe(function (user) { return _this.users[_this.updateIndex] = user; }, function (error) { return _this.errorMessage = error; });
                    }
                    else {
                        this.userService.addPo(data).subscribe(function (user) { return _this.users.push(user); }, function (error) { return _this.errorMessage = error; });
                    }
                    //jQuery(function(){
                    //    alert("jquery3");
                    //});
                    $('#myModal').modal('hide');
                };
                UserListComponent.prototype.fileUpload = function (data) {
                    var _this = this;
                    this.userService.fileUpload(data).subscribe(function (resultPo) { return resultPo.id = 1; }, function (error) { return _this.errorMessage = error; });
                };
                UserListComponent = __decorate([
                    core_1.Component({
                        selector: 'user-list',
                        templateUrl: 'app/sys/html/user.html',
                    }),
                    core_1.Injectable(), 
                    __metadata('design:paramtypes', [user_service_1.UserService])
                ], UserListComponent);
                return UserListComponent;
            })();
            exports_1("UserListComponent", UserListComponent);
        }
    }
});
//# sourceMappingURL=user-list.component.js.map