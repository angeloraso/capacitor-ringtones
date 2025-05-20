export interface RingtonesPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
