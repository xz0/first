import {Component, Injectable}     from 'angular2/core';
import {Http, Response,Headers, RequestOptions} from 'angular2/http';
import {UserPo}    from '../po/UserPo';
import {ResultPo}    from '../../common/resultPo.conponent';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class UserService {
    constructor (private http: Http) {

    }
    getPos () {
        return this.http.get("/user/getPos.d")
            .map(res => <UserPo[]> res.json())
            .do(res => console.log("resJson:"+JSON.stringify(res))) // eyeball results in the console
            .catch(this.handleError);
    }

    addPo (data: string) : Observable<UserPo>  {
        let body = JSON.stringify(data);
        //body = JSON.stringify( {data} );
        //alert(body);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post("/user/addPo.d", body, options)
            .map(res =>  <UserPo> res.json())
            .catch(this.handleError)
    }

    updatePo (data)  : Observable<UserPo>  {
        let body = JSON.stringify(data);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post("/user/updatePo.d", data, options)
            .map(res =>  <UserPo> res.json())
            .catch(this.handleError)
    }

    deletePo (id: number) {
        return this.http.delete("/user/deletePo/"+id+".d")
            .map(res => <ResultPo> res.json())
            .do(res => console.log("resJson:"+JSON.stringify(res))) // eyeball results in the console
            .catch(this.handleError);
    }

    fileUpload (data)   {
        //let body = JSON.stringify(data);
        let headers = new Headers({ 'Content-Type': undefined});
        let options = new RequestOptions({ headers: headers });
        return this.http.post("/user/upload.d", data, options)
            .map(res =>  <UserPo> res.json())
            .catch(this.handleError)
    }


    private handleError (error: Response) {
        console.error("错误信息2："+JSON.stringify(error));
        //return Observable.throw(error.json().error || 'Server error');
        return Observable.throw('服务器出错了');
    }

}

