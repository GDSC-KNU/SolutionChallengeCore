package gdsc.knu.dlycmntwrk.service

import gdsc.knu.dlycmntwrk.domain.Office
import gdsc.knu.dlycmntwrk.dto.AddOfficeDto
import gdsc.knu.dlycmntwrk.dto.FindOfficesRequest
import gdsc.knu.dlycmntwrk.repository.OfficeRepository
import org.locationtech.jts.geom.Point
import org.locationtech.jts.io.WKTReader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OfficeService(
    private val officeRepository: OfficeRepository
) {
    private val wktReader = WKTReader()

    fun findOffices(findOfficesRequest: FindOfficesRequest): List<Office> {
        val lineString = with(findOfficesRequest) {
            "LINESTRING($swLongitude $swLatitude, $enLongitude $enLatitude)"
        }

        return officeRepository.findAllByLocationsBetween(lineString)
    }

    @Transactional
    fun addOffice(officeDto: AddOfficeDto) {
        val office = Office(
            name = officeDto.name,
            location = getLocation(officeDto.longitude, officeDto.latitude)
        )

        officeRepository.save(office)
    }

    private fun getLocation(longitude: Double, latitude: Double): Point {
        val pointWKT = String.format("POINT(%s %s)", longitude, latitude)

        return wktReader.read(pointWKT) as Point
    }

}