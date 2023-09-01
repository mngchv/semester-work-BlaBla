package ru.kpfu.itis.dtos;



import lombok.Data;

@Data
public class CommentDto {

    private Long userID;
    private String comment;
    private Long rideID;
}
