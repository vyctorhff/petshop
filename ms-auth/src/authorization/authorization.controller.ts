import { Controller, Post, Body } from '@nestjs/common';
import { AuthorizationService } from './authorization.service';
import { TokenRequestDTO } from './dtos/token.request.dto';
import { TokenResponseDTO } from './dtos/token.response.dto';

@Controller('authorization')
export class AuthorizationController {

  constructor(private readonly authService: AuthorizationService) {}

  @Post()
  async token(@Body() tokenRequest: TokenRequestDTO): Promise<TokenResponseDTO> {
    return await this.authService.getToken(tokenRequest);
  }
}
