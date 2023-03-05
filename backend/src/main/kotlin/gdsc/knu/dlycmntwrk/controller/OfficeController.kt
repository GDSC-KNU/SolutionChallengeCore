package gdsc.knu.dlycmntwrk.controller

import gdsc.knu.dlycmntwrk.dto.AddOfficeDto
import gdsc.knu.dlycmntwrk.service.OfficeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/offices")
class OfficeController(
    private val officeService: OfficeService
) {

    @PostMapping("")
    fun addOffice(@RequestBody addOfficeDto: AddOfficeDto) {
        officeService.addOffice(addOfficeDto)
    }
}