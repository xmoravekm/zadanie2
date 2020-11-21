package sk.stuba.fei.uim.asos.assignment2;

import sk.stuba.fei.uim.asos.assignment2.insurance.service.InsuranceService;
import sk.stuba.fei.uim.asos.assignment2.ws.Insurance;
import sk.stuba.fei.uim.asos.assignment2.ws.InsuranceServicePortType;
import sk.stuba.fei.uim.asos.assignment2.ws.Insurances;
import sk.stuba.fei.uim.asos.assignment2.ws.ObjectFactory;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "InsuranceServicePortType", targetNamespace = "schemaWSDL")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class InsuranceEndpoint implements InsuranceServicePortType  {

    public InsuranceService insuranceService;

    public InsuranceEndpoint(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @Override
    public Insurances getAll() {
        return null;
    }

    @Override
    public Insurance create(Insurance parameters) {
        return null;
    }

    @Override
    public Insurance update(Insurance parameters) {
        return null;
    }

    @Override
    public Insurance getByUserId(long parameters) {
        return null;
    }


}
