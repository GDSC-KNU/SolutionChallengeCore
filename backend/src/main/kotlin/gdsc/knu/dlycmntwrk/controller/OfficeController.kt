package gdsc.knu.dlycmntwrk.controller

import gdsc.knu.dlycmntwrk.dto.*
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
            .map { officeToOfficeForListDto(it) }

        return FindOfficesResponse(offices = offices)
    }

    @GetMapping("/detail")
    fun findOfficesByIds(@RequestParam(name = "ids") officeIds: List<Long>): FindOfficesByIdsResponse {
        val offices = officeService
            .findOfficesByIds(officeIds)
            .map { officeToOfficeDto(it) }

        return FindOfficesByIdsResponse(offices = offices)
    }

    @GetMapping("/{officeId}")
    fun findOffice(@PathVariable officeId: Long): FindOfficeResponse {
        val office = officeService.findOffice(officeId).orElseThrow { NotFoundException() }
        val officeDto = officeToOfficeDto(office)

        return FindOfficeResponse(office = officeDto)
    }


    @PostMapping("")
    fun addOffice(@RequestBody addOfficeDto: AddOfficeDto) {
        officeService.addOffice(addOfficeDto)
    }
}