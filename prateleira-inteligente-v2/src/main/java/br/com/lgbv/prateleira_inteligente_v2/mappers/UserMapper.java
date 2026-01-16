                            package br.com.lgbv.prateleira_inteligente_v2.mappers;

                            import br.com.lgbv.prateleira_inteligente_v2.dto.UserDTO;
                            import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
                            import org.mapstruct.Mapper;
                            import org.mapstruct.Mapping;

                            @Mapper(componentModel = "spring")
                            public interface UserMapper extends BaseMapper<AppUser, UserDTO> {

                                @Override
                                @Mapping(target = "userBooks", expression = "java(toIds(entity.getUserBooks()))")
                                @Mapping(target = "comments", expression = "java(toIds(entity.getComments()))")
                                UserDTO toDto(AppUser entity);

                                @Override
                                @Mapping(target = "userBooks", ignore = true)
                                @Mapping(target = "comments", ignore = true)
                                AppUser toEntity(UserDTO dto);
                            }
