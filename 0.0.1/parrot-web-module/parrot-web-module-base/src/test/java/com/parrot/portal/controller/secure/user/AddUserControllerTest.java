package com.parrot.portal.controller.secure.user;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.domain.factory.impl.DefaultDomainFactory;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", "/WEB-INF/base-user-servlet.xml" })
public class AddUserControllerTest {
    
    @Autowired
    private AddUserController controller;
    
    @Autowired
    private DefaultDomainFactory defaultDomainFactory;
    
    private IUserManagementService serviceMock;
    
    /**
     * @param controller
     *                the controller to set
     */
    public void setController(AddUserController controller) {
        this.controller = controller;
    }
    
    /**
     * @param defaultDomainFactory
     *                the defaultDomainFactory to set
     */
    public void setDefaultDomainFactory(DefaultDomainFactory defaultDomainFactory) {
        this.defaultDomainFactory = defaultDomainFactory;
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.controller.secure.user.AddUserController#formBackingObject(javax.servlet.http.HttpServletRequest)}.
     */
    @Test
    public void testFormBackingObjectHttpServletRequest() {
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        
        try {
            assertTrue(IUser.class.isAssignableFrom(controller.formBackingObject(request).getClass()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.controller.secure.user.AddUserController#onSubmit(java.lang.Object)}.
     */
    @Test
    public void testOnSubmitObject() {
        
        IUser user = defaultDomainFactory.getDomainObject(IUser.class);
        user.getContact().getName().setFirstName("Vitek");
        user.getContact().getName().setLastName("Tajzich");
        
        serviceMock = EasyMock.createMock(IUserManagementService.class);
        controller.setUserManagementService(serviceMock);
        
        EasyMock.reportMatcher(new UserArgumentMatcher());
        EasyMock.expect(serviceMock.insertUser(user)).andReturn(user);
        
        EasyMock.replay(serviceMock);
        
        // prepare request
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/portal/add-user.html");
        request.setParameter("contact.name.firstName", user.getContact().getName().getFirstName());
        request.setParameter("contact.name.lastName", user.getContact().getName().getLastName());
        
        MockHttpServletResponse response = new MockHttpServletResponse();
        ModelAndView result = null;
        
        try {
            result = controller.handleRequest(request, response);
        } catch (Exception e) {
            fail();
        }
        
        EasyMock.verify(serviceMock);
        
        // test that Controller redirected to the another view
        assertTrue(RedirectView.class.isAssignableFrom(result.getView().getClass()));
    }
    
    private class UserArgumentMatcher implements IArgumentMatcher {
        
        /** {@inheritDoc} */
        public void appendTo(StringBuffer arg0) {
            
        }
        
        /** {@inheritDoc} */
        public boolean matches(Object arg0) {
            return IUser.class.isAssignableFrom(arg0.getClass());
        }
    }
}
