package com.lti.resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginDto;
import com.lti.dto.AdminStatus;
import com.lti.dto.DocumentDto;
import com.lti.dto.FullLoanAppDto;
import com.lti.dto.IncomeStatus;
import com.lti.dto.LoanAppStatus;
import com.lti.dto.LoginDto;
import com.lti.dto.LoginStatus;
import com.lti.dto.ProfilePicDto;
import com.lti.dto.PropertyStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.IncomeDetails;
import com.lti.entity.LoanApplication;
import com.lti.entity.LoanDocument;
import com.lti.entity.Property;
import com.lti.exception.CustomerServiceException;
import com.lti.repository.CustDao;
import com.lti.repository.IncomeDao;
import com.lti.repository.PropertyDao;
import com.lti.service.AdminService;
import com.lti.service.CustService;
import com.lti.service.IncomeService;
import com.lti.service.LoanApplicationService;
import com.lti.service.LoanDocsService;
import com.lti.service.PropertyService;

@RestController
@CrossOrigin
public class HLController {

	@Autowired
	private CustService custService;

	@Autowired
	private IncomeService incomeService;

	@Autowired
	private LoanDocsService lDocsService;

	@Autowired
	private LoanApplicationService loanApplicationService;

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustDao custDao;

	@Autowired
	private IncomeDao incomeDao;

	@Autowired
	private PropertyDao propertyDao;

	LoanDocument loanDocument = new LoanDocument();

//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public Customer addOrUpdateUser(@RequestBody Customer customer) {
//		Customer custPersisted = custService.addOrUpdateCustomer(customer);
//		return custPersisted;
//	}

	/*
	 * @PostMapping("/fullupdate") public Status fullUpdate(FullLoanAppDto
	 * fullLoanAppDto) { try { custService.updateAUser(customer);
	 * 
	 * Status status = new Status(); status.setStatus(StatusType.SUCCESS);
	 * status.setMessage("Detials addedd successfully!"); return status; }
	 * catch(CustomerServiceException e) { Status status = new Status();
	 * status.setStatus(StatusType.FAILURE); status.setMessage(e.getMessage());
	 * return status; } }
	 */

	@PostMapping("/updateUser")
	public Status updateUser(@RequestBody Customer customer) {
		try {
			custService.updateAUser(customer);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Detials addedd successfully!");
			return status;
		} catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/login")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		try {
			Customer customer = custService.login(loginDto.getCustEmail(), loginDto.getCustPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful!");
			loginStatus.setCustId(customer.getCustId());
			loginStatus.setCustName(customer.getCustName());
			return loginStatus;
		} catch (CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}

	@PostMapping(path = "/register")
	public Status register(@RequestBody Customer customer) {
		try {
			custService.register(customer);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful!");
			return status;
		} catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@GetMapping(value = "/finduser/{custId}")
	public Customer findCustById(@PathVariable("custId") int custId) {
		return custService.findCustById(custId);

	}
	@GetMapping(value = "/findLoan/{loanAppNo}")
	public LoanApplication findLoanById(@PathVariable("loanAppNo") int loanAppNo) {
		return loanApplicationService.findLoanById(loanAppNo);

	}

//	@PostMapping(value="/addOrUpdateLoanApplication/{custId}") 
//	public Status addOrUpdateLoanApplication(@RequestBody LoanApplication loanApplication,@PathVariable int custId){
//		try {
//			System.out.println(custId);
//		loanApplicationService.addOrUpdateLoanApplication(loanApplication, custId);
//		
//		Status status = new Status();
//        status.setStatus(StatusType.SUCCESS);
//        status.setMessage("Detials addedd successfully!");
//        return status;
//    }
//    catch(CustomerServiceException e) {
//        Status status = new Status();
//        status.setStatus(StatusType.FAILURE);
//        status.setMessage(e.getMessage());
//        return status;
//    }	
//	}

	@PostMapping(value = "/addOrUpdateLoanApplication")
	public LoanAppStatus addOrUpdateLoanApplication(@RequestBody LoanApplication loanApplication,
			@RequestParam int custId, @RequestParam int incomeId, @RequestParam int propertyId) {

		System.out.println(custId);
		LoanApplication application = loanApplicationService.addOrUpdateLoanApplication(loanApplication, custId,
				incomeId, propertyId);

		LoanAppStatus status = new LoanAppStatus();
		status.setLoanAppNo(application.getLoanAppNo());
		return status;
	}

	@PostMapping(value = "/addOrUpdateLoanIncome/{incomeId}")
	public Status addOrUpdateLoanIncome(@RequestBody LoanApplication loanApplication, @PathVariable int incomeId) {
		try {
			System.out.println(incomeId);
			loanApplicationService.addOrUpdateLoanIncome(loanApplication, incomeId);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Detials addedd successfully!");
			return status;
		} catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	@PostMapping(value = "/addOrUpdateLoanProperty/{propertyId}")
	public Status addOrUpdateLoanProperty(@RequestBody LoanApplication loanApplication, @PathVariable int propertyId) {
		try {
			System.out.println(propertyId);
			loanApplicationService.addOrUpdateLoanProperty(loanApplication, propertyId);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Detials addedd successfully!");
			return status;
		} catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

	}

	@PostMapping(value = "/viewallloanapplications")
	public List<LoanApplication> viewAllLoanApplications() {
		List<LoanApplication> loanapplications = loanApplicationService.viewAllLoanApplications();
		return loanapplications;
	}

	@PostMapping("/pic-upload")
	public Status upload(ProfilePicDto profilePicDto) {
		String imageUploadLocation = "d:/uploads/";
		String fileName = profilePicDto.getProfilePic().getOriginalFilename();
		String targetFile = imageUploadLocation + fileName;
		try {
			FileCopyUtils.copy(profilePicDto.getProfilePic().getInputStream(), new FileOutputStream(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

		Customer customer = custService.findCustById(profilePicDto.getCustId());
		customer.setProfilePic(fileName);
		custService.update(customer);

		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}

	@PostMapping("/doc-upload")
	public Status upload(DocumentDto documentDto) {
		String imageUploadLocation = "d:/uploads/";
		String Pan = documentDto.getPan().getOriginalFilename();
		String Aadhar = documentDto.getAadhar().getOriginalFilename();
		String loa = documentDto.getLoa().getOriginalFilename();
		String salesDeed = documentDto.getSalesDeed().getOriginalFilename();
		String paySlip = documentDto.getPaySlip().getOriginalFilename();
		String bankStatement = documentDto.getBankStatement().getOriginalFilename();
		String noc = documentDto.getNoc().getOriginalFilename();
		String incomeTax = documentDto.getIncomeTax().getOriginalFilename();

		String targetFile = imageUploadLocation + Pan;
		String targetFile1 = imageUploadLocation + Aadhar;
		String targetFile2 = imageUploadLocation + loa;
		String targetFile3 = imageUploadLocation + salesDeed;
		String targetFile4 = imageUploadLocation + paySlip;
		String targetFile5 = imageUploadLocation + bankStatement;
		String targetFile6 = imageUploadLocation + noc;
		String targetFile7 = imageUploadLocation + incomeTax;

		try {
			FileCopyUtils.copy(documentDto.getPan().getInputStream(), new FileOutputStream(targetFile));
			FileCopyUtils.copy(documentDto.getAadhar().getInputStream(), new FileOutputStream(targetFile1));
			FileCopyUtils.copy(documentDto.getLoa().getInputStream(), new FileOutputStream(targetFile2));
			FileCopyUtils.copy(documentDto.getSalesDeed().getInputStream(), new FileOutputStream(targetFile3));
			FileCopyUtils.copy(documentDto.getPaySlip().getInputStream(), new FileOutputStream(targetFile4));
			FileCopyUtils.copy(documentDto.getBankStatement().getInputStream(), new FileOutputStream(targetFile5));
			FileCopyUtils.copy(documentDto.getNoc().getInputStream(), new FileOutputStream(targetFile6));
			FileCopyUtils.copy(documentDto.getIncomeTax().getInputStream(), new FileOutputStream(targetFile7));

		} catch (IOException e) {
			e.printStackTrace();
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}

//        LoanDocument loanDocument = lDocsService.getDocs(documentDto.getCustId());
		LoanDocument loanDocument = new LoanDocument();
		loanDocument.setCustomer(custDao.findCustById(documentDto.getCustId()));
//        loanDocument.setPan(documentDto.getPan().toString());
		loanDocument.setLoanApplication(loanApplicationService.findLoanById(documentDto.getLoanAppNo()));		loanDocument.setPan(Pan);
		loanDocument.setAadhar(Aadhar);
		loanDocument.setLoa(loa);
		loanDocument.setSalesDeed(salesDeed);
		loanDocument.setPaySlip(paySlip);
		loanDocument.setBankStatement(bankStatement);
		loanDocument.setNoc(noc);
		loanDocument.setIncomeTax(incomeTax);
		lDocsService.updateDocs(loanDocument);

		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Uploaded!");
		return status;
	}

	@PostMapping(path = "/adddocs")
	public LoanDocument addDocs(@RequestBody LoanDocument loanDocument) {

		return lDocsService.updateDocs(loanDocument);
	}

//	@PostMapping("/updateIncome")
//    public Status updateIncome(@RequestBody IncomeDetails incomeDetails) {
//        try {
//            incomeService.updateIncome(incomeDetails);
//           
//            Status status = new Status();
//            status.setStatus(StatusType.SUCCESS);
//            status.setMessage("Detials addedd successfully!");
//            return status;
//        }
//        catch(CustomerServiceException e) {
//            Status status = new Status();
//            status.setStatus(StatusType.FAILURE);
//            status.setMessage(e.getMessage());
//            return status;
//        }
//    }
	@PostMapping("/updateIncome")
	public IncomeStatus updateIncome(@RequestBody IncomeDetails incomeDetails) {
		IncomeDetails details = incomeService.updateIncome(incomeDetails);
		System.out.println(details.getIncomeId());
		IncomeStatus incomest = new IncomeStatus();
		incomest.setIncomeId(details.getIncomeId());
		return incomest;

	}

	@PostMapping("/updateProperty")
	public PropertyStatus updateProperty(@RequestBody Property property) {
		Property property2 = propertyService.updateProperty(property);
		System.out.println(property2.getPropertyId());
		PropertyStatus propertyStatus = new PropertyStatus();
		propertyStatus.setPropertyId(property2.getPropertyId());
		return propertyStatus;

	}

//	@PostMapping("/updateProperty")
//    public Status updateProperty(@RequestBody Property property) {
//        try {
//            propertyService.updateProperty(property);
//           
//            Status status = new Status();
//            status.setStatus(StatusType.SUCCESS);
//            status.setMessage("Detials addedd successfully!");
//            return status;
//        }
//        catch(CustomerServiceException e) {
//            Status status = new Status();
//            status.setStatus(StatusType.FAILURE);
//            status.setMessage(e.getMessage());
//            return status;
//        }
//    }
	@PostMapping(path = "/adminregister")
	public Status adminregister(@RequestBody Admin admin) {
		try {
			adminService.save(admin);

			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration successful!");
			return status;
		} catch (CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/adminlogin")
	public AdminStatus adminlogin(@RequestBody AdminLoginDto adminLoginDto) {
		try {
			Admin admin = adminService.adminLogin(adminLoginDto.getAdminEmail(), adminLoginDto.getAdminPassword());
			AdminStatus adminStatus = new AdminStatus();
			adminStatus.setStatus(StatusType.SUCCESS);
			adminStatus.setMessage("Login Successful!");
			adminStatus.setAdminId(admin.getAdminId());
			adminStatus.setAdminName(admin.getAdminName());
			return adminStatus;
		} catch (CustomerServiceException e) {
			AdminStatus adminStatus = new AdminStatus();
			adminStatus.setStatus(StatusType.FAILURE);
			adminStatus.setMessage(e.getMessage());
			return adminStatus;
		}
	}

}
