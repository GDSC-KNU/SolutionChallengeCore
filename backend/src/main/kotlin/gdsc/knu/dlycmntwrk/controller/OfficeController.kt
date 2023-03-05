package gdsc.knu.dlycmntwrk.controller

import gdsc.knu.dlycmntwrk.dto.AddOfficeDto
import gdsc.knu.dlycmntwrk.dto.FindOfficesRequest
import gdsc.knu.dlycmntwrk.dto.FindOfficesResponse
import gdsc.knu.dlycmntwrk.dto.officeToOfficeForList
import gdsc.knu.dlycmntwrk.service.OfficeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/offices")
class OfficeController(
    private val officeService: OfficeService
) {

    @GetMapping("")
    fun findOffices(findOfficesRequest: FindOfficesRequest): FindOfficesResponse {
        val offices = officeService
            .findOffices(findOfficesRequest)
            .map { officeToOfficeForList(it) }

        return FindOfficesResponse(offices = offices)
    }

    @PostMapping("")
    fun addOffice(@RequestBody addOfficeDto: AddOfficeDto) {
        officeService.addOffice(addOfficeDto)
    }
}