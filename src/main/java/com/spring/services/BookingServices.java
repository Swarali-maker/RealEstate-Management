package com.spring.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Booking;
import com.spring.repository.BookingRepository;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBooking(Long id, Booking booking) {

        Booking existing = getBookingById(id);

        existing.setBookingAmount(booking.getBookingAmount());
        existing.setBookingDate(booking.getBookingDate());
        existing.setRemarks(booking.getRemarks());
        existing.setStatus(booking.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return bookingRepository.save(existing);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking getBookingByLeadId(Long leadId) {
        return bookingRepository.findByLead_LeadId(leadId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
