System.register(['angular2/core', 'angular2/http', 'rxjs/Observable'], function(exports_1) {
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, http_1, Observable_1;
    var UserService;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (http_1_1) {
                http_1 = http_1_1;
            },
            function (Observable_1_1) {
                Observable_1 = Observable_1_1;
            }],
        execute: function() {
            UserService = (function () {
                function UserService(http) {
                    this.http = http;
                }
                UserService.prototype.getPos = function () {
                    return this.http.get("/user/getPos.d")
                        .map(function (res) { return res.json(); })
                        .do(function (res) { return console.log("resJson:" + JSON.stringify(res)); }) // eyeball results in the console
                        .catch(this.handleError);
                };
                UserService.prototype.addPo = function (data) {
                    var body = JSON.stringify(data);
                    //body = JSON.stringify( {data} );
                    //alert(body);
                    var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
                    var options = new http_1.RequestOptions({ headers: headers });
                    return this.http.post("/user/addPo.d", body, options)
                        .map(function (res) { return res.json(); })
                        .catch(this.handleError);
                };
                UserService.prototype.updatePo = function (data) {
                    var body = JSON.stringify(data);
                    var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
                    var options = new http_1.RequestOptions({ headers: headers });
                    return this.http.post("/user/updatePo.d", data, options)
                        .map(function (res) { return res.json(); })
                        .catch(this.handleError);
                };
                UserService.prototype.deletePo = function (id) {
                    return this.http.delete("/user/deletePo/" + id + ".d")
                        .map(function (res) { return res.json(); })
                        .do(function (res) { return console.log("resJson:" + JSON.stringify(res)); }) // eyeball results in the console
                        .catch(this.handleError);
                };
                UserService.prototype.fileUpload = function (data) {
                    //let body = JSON.stringify(data);
                    var headers = new http_1.Headers({ 'Content-Type': undefined });
                    var options = new http_1.RequestOptions({ headers: headers });
                    return this.http.post("/user/upload.d", data, options)
                        .map(function (res) { return res.json(); })
                        .catch(this.handleError);
                };
                UserService.prototype.handleError = function (error) {
                    console.error("错误信息2：" + JSON.stringify(error));
                    //return Observable.throw(error.json().error || 'Server error');
                    return Observable_1.Observable.throw('服务器出错了');
                };
                UserService = __decorate([
                    core_1.Injectable(), 
                    __metadata('design:paramtypes', [http_1.Http])
                ], UserService);
                return UserService;
            })();
            exports_1("UserService", UserService);
        }
    }
});
//# sourceMappingURL=user.service.js.map