package sk.stuba.fei.uim.asos.assignment2;

import sk.stuba.fei.uim.asos.assignment2.insurance.service.IInsuranceContractService;
import sk.stuba.fei.uim.asos.assignment2.user.service.IUserService;
import sk.stuba.fei.uim.asos.assignment2.user.service.UserService;
import sk.stuba.fei.uim.asos.assignment2.ws.ObjectFactory;
import sk.stuba.fei.uim.asos.assignment2.ws.User;
import sk.stuba.fei.uim.asos.assignment2.ws.UserServicePortType;
import sk.stuba.fei.uim.asos.assignment2.ws.Users;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@WebService(name = "UserServicePortType", targetNamespace = "schemaWSDL")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class UserEndpoint implements UserServicePortType  {

    private UserService userService;

    public UserEndpoint() {
    }

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Users list() {
        Users users = new Users();
        users.getUser().addAll(userService.getAll());
        return users;
    }

    @Override
    public User add(User parameters) {
        userService.add(parameters);
        return parameters;
    }

    @Override
    public User update(User parameters) {
        userService.update(parameters);
        return parameters;
    }

    @Override
    public User getOne(long parameters) {
        return (User) userService.getOne(parameters);
    }

}
